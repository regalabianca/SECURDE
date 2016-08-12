package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import models.Account;
import models.Password;
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
		int type = Integer.parseInt(request.getParameter(Account.COL_TYPE));
		String confirmPass = request.getParameter("confirmPass");
		
		// user
		String firstName = request.getParameter(User.COL_FNAME);
		String lastName = request.getParameter(User.COL_LNAME);
		String middleInitial = request.getParameter(User.COL_MINIT);
		String email = request.getParameter(User.COL_EMAIL);
	
		if (password.equals(confirmPass)){
			
			Account account = new Account();
			account.setUsername(username);
			account.setType(type);
			Password pass = new Password();
			password = pass.hashPassword(password);
			
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMiddleInitial(middleInitial);
			user.setEmail(email);
			
			DBManager dbmanager = new DBManager();
			boolean added = dbmanager.signup(user, account, password);
			
			Account currentAccount  = (Account) request.getSession().getAttribute("account");
			
			if(added && currentAccount == null){
				request.getSession().setAttribute("account", account);
				String homepage = "";
				switch (account.getType()){
					case 0: homepage = "index.jsp";
							break;
					case 1: homepage = "admin index.jsp";
							break;
					case 2: homepage = "product manager index.jsp";
							break;
					case 3:	homepage = "accounting manager index.jsp";
							break;	
					default: homepage = "index.jsp";
				}
				request.getRequestDispatcher(homepage).forward(request, response);
			} else if(added && currentAccount.getType() == 1 ){
				request.getRequestDispatcher("admin index.jsp").forward(request, response);
			}else{
				response.sendRedirect("register.jsp");
			}
		} else {
			response.sendRedirect("register.jsp");
		}
	}

}