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
import modelAccess.CategoryDao;
import modelAccess.ReviewDao;
import modelAccessImpl.AccountDaoImpl;
import modelAccessImpl.CategoryDaoImpl;
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
		
		CategoryDao cd = new CategoryDaoImpl();
		request.getSession().setAttribute("category", cd.getCategory(p.getCategoryId()).getCategoryName());
		
		ReviewDao rd = new ReviewDaoImpl();
		ArrayList<Review> reviews = new ArrayList<>();
		reviews = rd.getReviews(productId);
		request.getSession().setAttribute("reviews", reviews);
		
		boolean validForReview;
		
		if(acct!=null){
			DBManager dbm = new DBManager();
			validForReview = dbm.checkIfValidForReview(acct.getAccountId(), productId);
			request.getSession().setAttribute("canReview", validForReview);
		}else{
			validForReview = false;
		}
		
		if(acct!=null){
			AccountDao ad = new AccountDaoImpl();
			int acctType = ad.getType(acct.getAccountId());
			request.getSession().setAttribute("type", acctType);
			if(acctType == 2)
				request.getRequestDispatcher("editproduct.jsp").forward(request, response);
			else
				request.getRequestDispatcher("single.jsp").forward(request, response);
		}else
			request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
