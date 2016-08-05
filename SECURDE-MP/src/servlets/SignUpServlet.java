package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import models.Account;
import models.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		
		// account
		String username = request.getParameter(Account.COL_USERNAME);
		String password = request.getParameter(Account.COL_PASSWORD);
//		int type = Integer.parseInt(request.getParameter(Account.COL_TYPE));
		String confirmPass = request.getParameter("confirmPass");
		
		// user
		String firstName = request.getParameter(User.COL_FNAME);
		String lastName = request.getParameter(User.COL_LNAME);
		String middleInitial = request.getParameter(User.COL_MINIT);
		String email = request.getParameter(User.COL_EMAIL);
//		int billingAddress = Integer.parseInt(request.getParameter(User.COL_BILLING));
//		int shippingAddress = Integer.parseInt(request.getParameter(User.COL_SHIPPING));
	
		if (password.equals(confirmPass)){
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
//			account.setType(type);
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMiddleInitial(middleInitial);
			user.setEmail(email);
//			user.setBillingAddress(billingAddress);
//			user.setShippingAddress(shippingAddress);
			
			DBManager dbmanager = new DBManager();
			account = dbmanager.signup(user, account);
			
			if(account != null){
				request.getSession().setAttribute("account", account);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else{
				response.sendRedirect("register.jsp");
			}
		} else {
			response.sendRedirect("register.jsp");
		}
	}

}