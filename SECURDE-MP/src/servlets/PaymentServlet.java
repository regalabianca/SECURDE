package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("GGGGGGGGGGG // Hello from [PAYMENT SERVLET] doPOST!");
		System.out.println("name = "+request.getParameter("cardName"));
		System.out.println("num = "+request.getParameter("houseNum0"));
		
		Account acct = (Account) request.getSession().getAttribute("account");
		request.setAttribute("account", acct);
		
		String cardName = request.getParameter("cardName");
		String cardNum = request.getParameter("cardNum");
		
		int houseNum0 = Integer.parseInt(request.getParameter("houseNum0"));
		String street0 = request.getParameter("street0");
		String subdivision0 = request.getParameter("subdivision0");
		String city0 = request.getParameter("city0");
		String postalCode0 = request.getParameter("postalCode0");
		String country0 = request.getParameter("country0");
		
		int houseNum1;
		String street1;
		String subdivision1;
		String city1;
		String postalCode1;
		String country1;
		
		if(request.getParameter("same-check") == null){
			houseNum1 = Integer.parseInt(request.getParameter("houseNum1"));
			street1 = request.getParameter("street1");
			subdivision1 = request.getParameter("subdivision1");
			city1 = request.getParameter("city1");
			postalCode1 = request.getParameter("postalCode1");
			country1 = request.getParameter("country1");
		}else{
			houseNum1 = houseNum0;
			street1 = street0;
			subdivision1 = subdivision0;
			city1 = city0;
			postalCode1 = postalCode0;
			country1 = country0;
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
