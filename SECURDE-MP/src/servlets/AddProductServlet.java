package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccess.ProductDao;
import modelAccessImpl.ProductDaoImpl;
import models.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		doGet(request, response);
		Product product = new Product();
		product.setDescription(request.getParameter("description"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		String c = request.getParameter("category");
		if(c.equals("boots"))
			product.setCategoryId(1);
		else if(c.equals("shoes"))
			product.setCategoryId(2);
		else if (c.equals("sandals"))
			product.setCategoryId(3);
		else if(c.equals("slippers"))
			product.setCategoryId(4);
		ProductDao pd = new ProductDaoImpl();
		pd.addProduct(product);
	}

}
