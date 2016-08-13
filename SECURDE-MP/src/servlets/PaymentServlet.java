package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccess.AddressDao;
import modelAccess.TransactionDao;
import modelAccessImpl.AddressDaoImpl;
import modelAccessImpl.TransactionDaoImpl;
import models.Account;
import models.Address;
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
		
		
		/*****************************************************************************************
		 * 	FOR ADDRESS TABLE
		 ****************************************************************************************/
		if(ad.getAddress(userId).size() < 1)
			newAddr = true;
		
		Address address = new Address();
		address.setUserId(userId);
		
		String cardName = request.getParameter("cardName");
		String cardNum = request.getParameter("cardNum");
		
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
			Transaction transaction = new Transaction();
			int accountId = acct.getAccountId();
			float totalPrice = Float.parseFloat(request.getParameter(Transaction.COL_TOTAL));
			transaction.setAccountId(accountId);
			transaction.setTotalPrice(totalPrice);
			
			TransactionDao td = new TransactionDaoImpl();
			td.addTransaction(transaction);
			
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
