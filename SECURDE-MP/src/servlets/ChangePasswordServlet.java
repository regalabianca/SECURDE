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
import modelAccessImpl.LogDao;
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
		LogDao log = new LogDao();
		
		System.out.println("change");
	
		
		Account account = (Account) request.getSession().getAttribute("account");
		Password pass = new Password();
		
		AccountDao ad = new AccountDaoImpl();
		String hashpassword = ad.getDefaultPassword(account.getUsername());
		
		
		if(newPass.equals(confirmPass) && !(oldPass.equals(newPass)) && ad.isPasswordValid(newPass)){
			if(pass.checkPassword(oldPass, hashpassword)){
				ad.setPassword(account.getUsername(), pass.hashPassword(newPass));
				log.addLog(request.getRemoteAddr(), "Successfully Changed Password", account.getAccountId());
				if(ad.getType(account.getAccountId()) == 2)
					response.sendRedirect("product manager index.jsp");
				else if(ad.getType(account.getAccountId()) == 3)
					response.sendRedirect("accounting manager index.jsp");
			}else{
				response.sendRedirect("changepassword.jsp");
				log.addLog(request.getRemoteAddr(), "Password Inputted does not match the default password", account.getAccountId());
			}
		}else{
			response.sendRedirect("changepassword.jsp");
		}
	}
}