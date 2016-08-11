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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Password pass = new Password();
	
		DBManager dbmanager = new DBManager();
		if(pass.checkPassword(password, dbmanager.getPassword(username))){
			Account account = dbmanager.login(username);
			
			System.out.println("account = "+account);
			if (account != null){
				request.getSession().setAttribute("account", account);
				String homepage = "";
				switch (account.getType()){
					case 1: homepage = "index.jsp";
							break;
					case 2: homepage = "product manager index.jsp";
							break;
					case 3: homepage = "accounting manager index.jsp";
							break;
					default: homepage = "index.jsp";
				}
				request.getRequestDispatcher(homepage).forward(request, response);
			} else {
				response.sendRedirect("account.jsp");
			}
		}else{
			response.sendRedirect("account.jsp");
		}
		
		
	}

}