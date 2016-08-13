package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccess.ReviewDao;
import modelAccessImpl.ProductDaoImpl;
import modelAccessImpl.ReviewDaoImpl;
import models.Account;
import models.Product;
import models.Review;

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
		Account acct = (Account) request.getSession().getAttribute("account");
		request.getSession().setAttribute("account", acct);
		
		Product p = new Product();
		
		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("viewproductslist");
		int index = Integer.parseInt(request.getParameter("index"));
		int productId = products.get(index).getProductId();
		
		ProductDaoImpl pd = new ProductDaoImpl();
		p = pd.getProduct(productId);
		request.getSession().setAttribute("product", p);
		
		ReviewDao rd = new ReviewDaoImpl();
		ArrayList<Review> reviews = new ArrayList<>();
		reviews = rd.getReviews(productId);
		request.getSession().setAttribute("reviews", reviews);
		
		if(acct!=null)
			if(acct.getType() == 2)
				request.getRequestDispatcher("editproduct.jsp").forward(request, response);
			else
				request.getRequestDispatcher("single.jsp").forward(request, response);
		else
			request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
