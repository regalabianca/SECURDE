package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccess.ProductDao;
import modelAccessImpl.ProductDaoImpl;
import models.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
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
		request.getSession().setAttribute("account", request.getSession().getAttribute("account"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		ArrayList<Product> p = new ArrayList<Product>();
		Product product = (Product) request.getSession().getAttribute("product");
//		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		//System.out.println(productId);
		ProductDao pd = new ProductDaoImpl();
		pd.deleteProduct(productId);
		switch(product.getCategoryId()){
			case 1:
			p = pd.getProducts(1);
			request.getSession().setAttribute("viewproductslist", p);
			request.getRequestDispatcher("productspage.jsp").forward(
					request, response);
			break;
			case 2:
				p = pd.getProducts(2);
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
			case 3:
				p = pd.getProducts(3);
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
			case 4:
				p = pd.getProducts(4);
				request.getSession().setAttribute("viewproductslist", p);
				request.getRequestDispatcher("productspage.jsp").forward(
						request, response);
			break;
			default:
				request.getRequestDispatcher("product manager index.jsp").forward(request, response);
				break;
		}
	}

}
