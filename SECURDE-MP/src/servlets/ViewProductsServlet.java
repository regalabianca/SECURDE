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
import models.Product;

/**
 * Servlet implementation class ViewProductsServlet
 */
@WebServlet("/ViewProductsServlet")
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
		System.out.println("HELLO DOPOST VIEW PRODUCTS " +request.getParameter("categoryId"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		ArrayList<Product> products = new ArrayList<>();
		
		DBManager dbmanager = new DBManager();
		products = dbmanager.getProducts(categoryId);
		
		request.getSession().setAttribute("products", products);	
		request.getRequestDispatcher("viewproducts.jsp").forward(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*System.out.println("ange");
		ArrayList<Product> p = new ArrayList();
		//request.removeAttribute("requestlist");
		//Profile prof = (Profile) request.getSession().getAttribute("profile");
		//r = new Manager().getAllProfRequest(p.getIdNo(), "All", "All","All");
		ProductDaoImpl pd = new ProductDaoImpl();
		p = pd.getProducts(1);
		System.out.println("desc:"+p.get(0).getDescription());
		System.out.println("price:"+p.get(0).getPrice());
		request.getSession().setAttribute("viewbootslist", p);

//		notif = new Manager().getAllProfNotif(p.getIdNo());
//		request.getSession().setAttribute("notif", notif);

//		ArrayList<String> s = new Manager()
//				.getAllStudentOfProf(p.getIdNo());
//		request.getSession().setAttribute("students", s);
//
//		c = new Manager().getAllProfessorCourses(p.getIdNo());
//		request.getSession().setAttribute("courses", c);

		request.getRequestDispatcher("boots page.jsp").forward(
				request, response);*/
	}

}
