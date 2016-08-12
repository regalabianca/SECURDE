package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("GGGGGGGGGGG // Hello from [PAYMENT SERVLET] doPOST!");
		
		String cardName = request.getParameter("cardName");
		String cardNum = request.getParameter("cardNum");
		
		int houseNum0 = Integer.parseInt(request.getParameter("b_houseNum"));
		String street0 = request.getParameter("b_street");
		String subdivision0 = request.getParameter("b_subdivision");
		String city0 = request.getParameter("b_city");
		String postalCode0 = request.getParameter("b_postalCode");
		String country0 = request.getParameter("b_country");
		
		int houseNum1 = Integer.parseInt(request.getParameter("s_houseNum"));
		String street1 = request.getParameter("s_street");
		String subdivision1 = request.getParameter("s_subdivision");
		String city1 = request.getParameter("s_city");
		String postalCode1 = request.getParameter("s_postalCode");
		String country1 = request.getParameter("s_country");
		
//		System.out.println();
//		System.out.println("name = "+cardName);
//		System.out.println("num ="+cardNum);
//		System.out.println();
//		System.out.println("houseNum0 = "+houseNum0);
//		System.out.println("street0 = "+street0);
//		System.out.println("subdivision0 = "+subdivision0);
//		System.out.println("city0 = "+city0);
//		System.out.println("postalCode0 = "+postalCode0);
//		System.out.println("country0 = "+country0);
//		System.out.println();
//		System.out.println("houseNum1 = "+houseNum1);
//		System.out.println("street1 = "+street1);
//		System.out.println("subdivision1 = "+subdivision1);
//		System.out.println("city1 = "+city1);
//		System.out.println("postalCode1 = "+postalCode1);
//		System.out.println("country1 = "+country1);
//		System.out.println();
		
		
	}

}
