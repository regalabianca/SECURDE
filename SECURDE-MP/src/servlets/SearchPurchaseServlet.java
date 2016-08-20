package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelAccessImpl.PurchaseDaoImpl;
import models.Purchase;

/**
 * Servlet implementation class SearchPurchaseServlet
 */
@WebServlet("/SearchPurchaseServlet")
public class SearchPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPurchaseServlet() {
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
		System.out.println("ji");
		PurchaseDaoImpl pd = new PurchaseDaoImpl();
		ArrayList<Purchase> p = new ArrayList<Purchase>();
		int t = Integer.parseInt(request.getParameter("target"));
		System.out.println(t);
		if(t==1)
		{
			String description = request.getParameter("searchString");
			if(description.isEmpty())
				p = pd.getPurchases();
			else
				p = pd.getPurchasesDescription(description);
		}
		else if(t==2)
		{
			int c = Integer.parseInt(request.getParameter("editCateg"));
			p = pd.getPurchasesCategory(c);
		}
		request.getSession().setAttribute("purchases",p);
		request.getRequestDispatcher("accounting manager index.jsp").forward(request, response);
	}

}
