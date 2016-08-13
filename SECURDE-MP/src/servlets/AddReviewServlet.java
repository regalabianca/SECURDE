package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccess.ReviewDao;
import modelAccessImpl.ReviewDaoImpl;
import models.Account;
import models.Product;
import models.Review;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
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
		Account account = (Account) request.getSession().getAttribute("account");
		request.setAttribute("account", account);
		Product product = (Product) request.getSession().getAttribute("product");
		request.setAttribute("product", product);
		
		String description = request.getParameter("reviewDesc");
		int productId = product.getProductId();
		int accountId = account.getAccountId();
		
		Review review = new Review();
		review.setDescription(description);
		review.setProductId(productId);
		review.setAccountId(accountId);
		
		ReviewDao rd = new ReviewDaoImpl();
		rd.addReview(review);
		
//		ArrayList<Review> reviews = new ArrayList<>();
//		reviews = (ArrayList<Review>) request.getSession().getAttribute("reviews");
//		reviews.add(review);
//		request.setAttribute("reviews", reviews);
		
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}

}
