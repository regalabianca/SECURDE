package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import modelAccess.AccountDao;
import modelAccessImpl.AccountDaoImpl;
import modelAccessImpl.ProductDaoImpl;
import modelAccessImpl.PurchaseDaoImpl;
import models.Account;
import models.Password;
import models.Purchase;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account account = (Account) request.getSession().getAttribute("account");
		request.getSession().setAttribute("account", account);
		if(account!=null){
			AccountDao ad = new AccountDaoImpl();
			int acctType = ad.getType(account.getAccountId());
			
			String homepage = "";
			switch (acctType){
				case 0: homepage = "index.jsp";
						break;
				case 1: homepage = "admin index.jsp";
						break;
				case 2: homepage = "product manager index.jsp";
						break;
				case 3:	PurchaseDaoImpl pd = new PurchaseDaoImpl();
						ArrayList<Purchase> p = new ArrayList<Purchase>();
						p = pd.getPurchases();
						request.getSession().setAttribute("purchases",p);
						homepage = "accounting manager index.jsp";
						break;	
				default: homepage = "index.jsp";
			}
			request.getRequestDispatcher(homepage).forward(request, response);
		}
		else
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet DoPost");
		Account account = (Account) request.getSession().getAttribute("account");
					request.getSession().setAttribute("account", account);
					AccountDao ad = new AccountDaoImpl();
					int acctType = ad.getType(account.getAccountId());
					
					String homepage = "";
					switch (acctType){
						case 0: homepage = "index.jsp";
								break;
						case 1: homepage = "admin index.jsp";
								break;
						case 2: homepage = "product manager index.jsp";
								break;
						case 3:	/*PurchaseDaoImpl pd = new PurchaseDaoImpl();
								pd.getPurchases();
								Gson g = new Gson();
								String s = g.toJson(pd);
								response.setContentType("application/json");*/
								homepage = "accounting manager index.jsp";
								break;	
						default: homepage = "index.jsp";
					}
					request.getRequestDispatcher(homepage).forward(request, response);
	}
}