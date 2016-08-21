package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccess.AddressDao;
import modelAccessImpl.AddressDaoImpl;
import modelAccessImpl.LogDao;
import models.Account;
import models.Address;
import models.Product;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account account = (Account) request.getSession().getAttribute("account");
		request.getSession().setAttribute("account", account);
		if(account!=null){
			ArrayList<Address> address = new ArrayList<>();
			AddressDao ad = new AddressDaoImpl();
			LogDao log = new LogDao();
			address = ad.getAddress(account.getUserId());
			
			if(address.size() > 0){
				request.getSession().setAttribute("address", "true");
				request.getSession().setAttribute("badr", address.get(0));
				request.getSession().setAttribute("sadr", address.get(1));
			}else{
				request.getSession().setAttribute("address", "false");
			}
			
			request.getSession().setAttribute("cart", request.getSession().getAttribute("cart"));
			
			ArrayList<Product> c = new ArrayList<Product>();
			c = (ArrayList<Product>) request.getSession().getAttribute("cart");
			
			float totalPrice = 0;
			int cart_size = c.size();
			for(int i = 0; i < cart_size; i++)
				totalPrice += c.get(i).getPrice();
			
			request.getSession().setAttribute("totalPrice", totalPrice);
			log.addLog(request.getRemoteAddr(), "Checked Out", account.getAccountId());
			
			request.getRequestDispatcher("payment.jsp").forward(request, response);
		}
		
	}

}
