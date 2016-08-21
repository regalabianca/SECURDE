package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBManager;
import modelAccess.ProductDao;
import modelAccessImpl.LogDao;
import modelAccessImpl.ProductDaoImpl;
import models.Account;
import models.Product;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entered doGET");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("aaaaaaaaa || Hello from <<UPDATE PRODUCT SERVLET>>");
		Account account = (Account) request.getSession().getAttribute("account");
		int productId = Integer.parseInt(request.getParameter("productId"));
		String description = request.getParameter("description");
		float price = Float.valueOf(request.getParameter("price"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		LogDao log = new LogDao();
		
		Product product = new Product();
		product.setProductId(productId);
		product.setDescription(description);
		product.setPrice(price);
		product.setCategoryId(categoryId);
		
		System.out.println("bbbbbbb >> categoryId = "+categoryId);
		
		ProductDao pd = new ProductDaoImpl();
		pd.updateProduct(product);
		log.addLog(request.getRemoteAddr(), "Updated Product with product id"+ product.getProductId() , account.getAccountId());
	}

}