


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBManager;
import modelAccess.AccountDao;
import modelAccessImpl.AccountDaoImpl;
import models.Account;

public class AuthenticationFilter implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		AccountDao ad = new AccountDaoImpl();
		
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession(false);
			
		if(session !=null){
			if(session.getAttribute("account")== null && !(uri.endsWith("ViewBootsServlet") || uri.endsWith("ViewShoesServlet")|| uri.endsWith("ViewSandalsServlet")|| uri.endsWith("ViewSlippersServlet")|| uri.endsWith("ViewSingleProductServlet")|| uri.endsWith("SignUpServlet")|| uri.endsWith("HomeServlet")|| uri.endsWith("LogInServlet")|| uri.endsWith("SearchServlet") || uri.endsWith("account.jsp")|| uri.endsWith("AddCartServlet")|| uri.endsWith("EmptyCartServlet")|| uri.endsWith("ViewCartServlet") || uri.endsWith("/SECURDE-MP/") || uri.endsWith("checkout.jsp"))){
				this.context.log("Unauthorized access request");
				res.sendRedirect("account.jsp");
			}else if(session.getAttribute("account")!= null){
				System.out.println("Account not null");
				Account current = (Account)session.getAttribute("account");
				int acctType = ad.getType(current.getAccountId());
				if(acctType == 1 && !(uri.endsWith("LogInServlet")|| uri.endsWith("registermanager.jsp") || uri.endsWith("SignUpServlet") || uri.endsWith("admin%20index.jsp") || uri.endsWith("LogOutServlet"))){
					session.invalidate();
					this.context.log("Unauthorized access request");
					res.sendRedirect("account.jsp");
				}else if(acctType == 2 && !(uri.endsWith("LogInServlet")|| uri.endsWith("ChangePasswordServlet") || uri.endsWith("product%20manager520index.jsp") || uri.endsWith("addproduct.jsp") || uri.endsWith("AddProductServlet") || uri.endsWith("ViewSingleProductServlet") || uri.endsWith("DeleteProductServlet") || uri.endsWith("ViewShoesServlet") || uri.endsWith("ViewSandalsServlet") || uri.endsWith("ViewSandalsServlet") || uri.endsWith("ViewSlippersServlet") || uri.endsWith("ViewBootsServlet")|| uri.endsWith("HomeServlet") ||uri.endsWith("SearchServlet") || uri.endsWith("UpdateProductServlet") )){
					session.invalidate();
					this.context.log("Unauthorized access request");
					res.sendRedirect("account.jsp");
				}else if(acctType == 0 && !(uri.endsWith("LogInServlet")|| uri.endsWith("ChangePasswordServlet")|| uri.endsWith("PaymentServlet")||uri.endsWith("ViewBootsServlet") || uri.endsWith("ViewShoesServlet")|| uri.endsWith("ViewSandalsServlet")|| uri.endsWith("ViewSlippersServlet")|| uri.endsWith("ViewSingleProductServlet")|| uri.endsWith("SignUpServlet")|| uri.endsWith("HomeServlet")|| uri.endsWith("LogInServlet")|| uri.endsWith("LogOutServlet")|| uri.endsWith("SearchServlet") || uri.endsWith("account.jsp")|| uri.endsWith("AddCartServlet")|| uri.endsWith("EmptyCartServlet")|| uri.endsWith("ViewCartServlet")|| uri.endsWith(""))){
					session.invalidate();
					this.context.log("Unauthorized access request");
					res.sendRedirect("account.jsp");
				}else if(acctType == 3 && !(uri.endsWith("LogInServlet")|| uri.endsWith("ChangePasswordServlet") || uri.endsWith("SearchPurchaseServlet")|| uri.endsWith("HomeServlet"))){
					session.invalidate();
					this.context.log("Unauthorized access request");
					res.sendRedirect("account.jsp");
				}
				else {
				chain.doFilter(request, response);
				}
			}
			else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		//close any resources here
	}

}
