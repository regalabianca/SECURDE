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
import models.Account;
import models.Address;

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
		
		ArrayList<Address> address = new ArrayList<>();
		AddressDao ad = new AddressDaoImpl();
		address = ad.getAddress(account.getUserId());
		
		if(address.size() > 0){
			request.getSession().setAttribute("address", "true");
			request.getSession().setAttribute("badr", address.get(0));
			request.getSession().setAttribute("sadr", address.get(1));
		}else{
			request.getSession().setAttribute("address", "false");
		}
		
		request.getSession().setAttribute("cart", request.getSession().getAttribute("cart"));
		
		request.getRequestDispatcher("payment.jsp").forward(request, response);
		
	}

}
