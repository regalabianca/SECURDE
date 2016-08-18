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
import modelAccessImpl.PurchaseDaoImpl;
import models.Account;
import models.Password;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getSession() != null){
			request.getSession().invalidate();
			response.sendRedirect("account.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String genpass;
		Password pass = new Password();
	
		DBManager dbmanager = new DBManager();
		AccountDao ad = new AccountDaoImpl();
		
		String hashpassword = dbmanager.getPassword(username);
		String defaultpassword = null;
		if(hashpassword == null){
			defaultpassword = ad.getDefaultPassword(username);
			genpass = defaultpassword;
		}else
			genpass = hashpassword;
		
		
		if(hashpassword != null || defaultpassword!=null && dbmanager.getAttempts(username) < 5){
			if(pass.checkPassword(password, genpass)){
				Account account = dbmanager.login(username);
				dbmanager.setAttempts(username);
					request.getSession().setAttribute("account", account);
					
					int acctType = ad.getType(account.getAccountId());
					
					String homepage = "";
					switch (acctType){
						case 0: homepage = "index.jsp";
								break;
						case 1: homepage = "admin index.jsp";
								break;
						case 2: if(hashpassword == null){
									homepage = "changepassword.jsp";
								}else{
									homepage = "product manager index.jsp";
								}
								break;
						case 3:	if(hashpassword == null){
									homepage = "changepassword.jsp";
								}else{
									/*PurchaseDaoImpl pd = new PurchaseDaoImpl();
									pd.getPurchases();
									Gson g = new Gson();
									String s = g.toJson(pd);
									response.setContentType("application/json");
									response.getWriter().write(s);*/
									homepage = "accounting manager index.jsp";
								}

								break;	
						default: homepage = "index.jsp";
					}
					request.getRequestDispatcher(homepage).forward(request, response);
			}else{
				dbmanager.increaseAttempts(username);
				response.sendRedirect("account.jsp");
			}
		}else{
			response.sendRedirect("account.jsp");
		}
	}

}