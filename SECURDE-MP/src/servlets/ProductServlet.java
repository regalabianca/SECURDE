package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import models.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		String command = request.getParameter("command");
		int productId = Integer.parseInt(request.getParameter("productId"));
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		int categoryId = Integer.parseInt("categoryId");
		
		Product product = new Product();
		product.setProductId(productId);
		product.setDescription(description);
		product.setPrice(price);
		product.setCategoryId(categoryId);
		
		DBManager dbmanager = new DBManager();
		
		switch(command){
			case "add":	dbmanager.addProduct(product);
						break;
			case "update":	dbmanager.updateProduct(product);
							break;
			case "delete":	dbmanager.deleteProduct(productId);
		}
	}

}
