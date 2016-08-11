package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccessImpl.ProductDaoImpl;
import models.Product;

/**
 * Servlet implementation class ViewSingleProductServlet
 */
@WebServlet("/ViewSingleProductServlet")
public class ViewSingleProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSingleProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product p = new Product();
		//request.removeAttribute("requestlist");
		//Profile prof = (Profile) request.getSession().getAttribute("profile");
		//r = new Manager().getAllProfRequest(p.getIdNo(), "All", "All","All");
		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("viewproductslist");
		int index = Integer.parseInt(request.getParameter("index"));
		ProductDaoImpl pd = new ProductDaoImpl();
		p = pd.getProduct(products.get(index).getProductId());
		request.getSession().setAttribute("product", p);
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
