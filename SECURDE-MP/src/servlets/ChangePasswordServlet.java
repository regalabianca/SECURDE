package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import modelAccess.AccountDao;
import modelAccessImpl.AccountDaoImpl;
import models.Account;
import models.Password;


@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*if(request.getSession() != null){
			request.getSession().invalidate();
			response.sendRedirect("account.jsp");
		}*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String confirmPass = request.getParameter("confirmPass");
	
		
		Account account = (Account) request.getSession().getAttribute("account");
		Password pass = new Password();
		
		AccountDao ad = new AccountDaoImpl();
		String hashpassword = ad.getDefaultPassword(account.getUsername());
		
		
		if(newPass.equals(confirmPass)){
			if(pass.checkPassword(oldPass, hashpassword)){
				ad.setPassword(account.getUsername(), pass.hashPassword(newPass));
				request.getSession().invalidate();
				response.sendRedirect("account.jsp");
			}else{
				response.sendRedirect("changepassword.jsp");
			}
		}else{
			response.sendRedirect("changepassword.jsp");
		}
	}

}
