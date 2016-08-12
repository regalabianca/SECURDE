package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Product;
 
/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet(urlPatterns={"/CartServlet","/AddCartServlet","/EmptyCartServlet","/ViewCartServlet"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Product> p = new ArrayList<Product>();
		Account acct = (Account) request.getSession().getAttribute("account");
		request.setAttribute("account", acct);
		switch(request.getServletPath()){
		case "/AddCartServlet":
			if((ArrayList<Product>) request.getSession().getAttribute("cart")!=null)
				p=(ArrayList<Product>) request.getSession().getAttribute("cart");
			Product temp = new Product();
			temp = (Product) request.getSession().getAttribute("product");
			p.add(temp);
			request.getSession().setAttribute("cart", p);
			request.getRequestDispatcher("single.jsp").forward(request, response);
			break;
		case "/EmptyCartServlet":
			request.getSession().removeAttribute("cart");
			break;
		case "/ViewCartServlet":
			p = (ArrayList<Product>)request.getSession().getAttribute("cart");
			request.setAttribute("cart", request.getSession().getAttribute("cart"));
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
