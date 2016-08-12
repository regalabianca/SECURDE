package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import modelAccessImpl.ProductDaoImpl;
import models.Account;
import models.Product;

/**
 * Servlet implementation class ViewProductsServlet
 */
@WebServlet(urlPatterns = {"/ViewProductsServlet","/ViewBootsServlet","/ViewShoesServlet","/ViewSandalsServlet","/ViewSlippersServlet","/SearchServlet"})
public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> p = new ArrayList<>();
		ProductDaoImpl pd = new ProductDaoImpl();
		Account acct = (Account) request.getSession().getAttribute("account");
		request.setAttribute("account", acct);
		switch (request.getServletPath()){
			case "/ViewBootsServlet":
			p = pd.getProducts(1);
			request.getSession().setAttribute("viewproductslist", p);
			request.getRequestDispatcher("productspage.jsp").forward(
					request, response);
			break;
			case "/ViewShoesServlet":
				p = pd.getProducts(2);
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
			case "/ViewSandalsServlet":
				p = pd.getProducts(3);
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
			case "/ViewSlippersServlet":
				p = pd.getProducts(4);
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
			case "/SearchServlet":
				p = pd.getSearchProducts(request.getParameter("search"));
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
		}
	}
}
