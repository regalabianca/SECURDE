package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import modelAccess.AddressDao;
import modelAccess.PurchaseDao;
import modelAccess.TransactionDao;
import modelAccessImpl.AddressDaoImpl;
import modelAccessImpl.PurchaseDaoImpl;
import modelAccessImpl.TransactionDaoImpl;
import models.Account;
import models.Address;
import models.Password;
import models.Product;
import models.Purchase;
import models.Transaction;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("GGGGGGGGGGG // Hello from [PAYMENT SERVLET] doPOST!");
		
		boolean newAddr = false;
		AddressDao ad = new AddressDaoImpl();
		
		Account acct = (Account) request.getSession().getAttribute("account");
		request.setAttribute("account", acct);
		int userId = acct.getUserId();
		
		Password p = new Password();
	
		String password = request.getParameter("confirmPassword");
		DBManager dbmanager = new DBManager();
		String hashpass = dbmanager.getPassword(acct.getUsername());
		
		boolean cardValid = false;
		
		String cardName = request.getParameter("cardName");
		String cardNum = request.getParameter("cardNum");
		String cardExpiry = request.getParameter("cardExpiry");
		
		String[] parts = cardExpiry.split("/");
		int year = Integer.parseInt(parts[2]);
		int day = Integer.parseInt(parts[1]);
		int month = Integer.parseInt(parts[0]);
		
		if(year > Calendar.getInstance().get(Calendar.YEAR)){
			System.out.println("valid year");
			cardValid = true;
		} else if (year == Calendar.getInstance().get(Calendar.YEAR)){
			if(month > (Calendar.getInstance().get(Calendar.MONTH)+1)){
				System.out.println("valid year, month");
				cardValid = true;
			}else if (month == Calendar.getInstance().get(Calendar.MONTH)+1){
				if(day >= Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
					System.out.println("valid year, month, day");
					cardValid = true;
				}
			}
		}
		
		if(p.checkPassword(password, hashpass) && cardValid){
			
			System.out.println("====================== ENTERED CORRECT PASSWORD PAYMENT");
			
		/*****************************************************************************************
		 * 	FOR ADDRESS TABLE
		 ****************************************************************************************/
		if(ad.getAddress(userId).size() < 1)
			newAddr = true;
		
		Address address = new Address();
		address.setUserId(userId);
		
		int houseNum0 = Integer.parseInt(request.getParameter("houseNum0"));
		String street0 = request.getParameter("street0");
		String subdivision0 = request.getParameter("subdivision0");
		String city0 = request.getParameter("city0");
		String postalCode0 = request.getParameter("postalCode0");
		String country0 = request.getParameter("country0");
		
		address.setHouseNum(houseNum0);
		address.setStreet(street0);
		address.setSubdivision(subdivision0);
		address.setCity(city0);
		address.setPostalCode(postalCode0);
		address.setCountry(country0);
		address.setType(0);
		
		if(newAddr) 
			ad.addAddress(address); // add billing address
		else
			ad.updateAddress(address);
		
		if(request.getParameter("same-check") == null){ // different billing and shipping
			int houseNum1 = Integer.parseInt(request.getParameter("houseNum1"));
			String street1 = request.getParameter("street1");
			String subdivision1 = request.getParameter("subdivision1");
			String city1 = request.getParameter("city1");
			String postalCode1 = request.getParameter("postalCode1");
			String country1 = request.getParameter("country1");
			
			address.setHouseNum(houseNum1);
			address.setStreet(street1);
			address.setSubdivision(subdivision1);
			address.setCity(city1);
			address.setPostalCode(postalCode1);
			address.setCountry(country1);
		}
		
			address.setType(1);
			
			if(newAddr)
				ad.addAddress(address); //add shipping address
			else
				ad.updateAddress(address);
			
			
			/*****************************************************************************************
			 * 	FOR TRANSACTION TABLE
			 ****************************************************************************************/
		
			ArrayList<Product> cart = new ArrayList<Product>();
			cart = (ArrayList<Product>) request.getSession().getAttribute("cart");
			
			float totalPrice = 0;
			int cart_size = cart.size();
			for(int i = 0; i < cart_size; i++)
				totalPrice += cart.get(i).getPrice();
			
			Transaction transaction = new Transaction();
			int accountId = acct.getAccountId();
			//float totalPrice = Float.parseFloat(request.getParameter(Transaction.COL_TOTAL));
			transaction.setAccountId(accountId);
			transaction.setTotalPrice(totalPrice);
			
			TransactionDao td = new TransactionDaoImpl();
			td.addTransaction(transaction);
			
			/*****************************************************************************************
			 * 	FOR PURCHASE TABLE
			 ****************************************************************************************/
			
			int transactionId = td.getLastTransaction(accountId).getTransactionId();
			
//			ArrayList<Purchase> purchases = new ArrayList<>();
//			purchases = (ArrayList<Purchase>) request.getSession().getAttribute("purchase_list");
			
			PurchaseDao pd = new PurchaseDaoImpl();
			
			for(int i=0; i<cart_size; i++){
				Purchase purchase = new Purchase();
				purchase.setQuantity(1);
				purchase.setProductId(cart.get(i).getProductId());
				purchase.setUnitPrice(cart.get(i).getPrice());
				purchase.setTotalPrice(cart.get(i).getPrice());
				purchase.setTransactionId(transactionId);
				pd.addPurchase(purchase);
			}
			
//			int size = purchases.size();
//			
//			for(int i = 0; i < size; i++){
//				Purchase purchase = new Purchase();
//				purchase = purchases.get(i);
//				purchase.setTransactionId(transactionId);
//				pd.addPurchase(purchase);
//			}
			
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			System.out.println("====================== ERROR!!! PASSWORD PAYMENT");
			request.getRequestDispatcher("payment.jsp").forward(request, response);
		}
	}

}
