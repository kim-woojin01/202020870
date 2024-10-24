package kr.ac.kku.cs.wp.kim_woojin01;

import java.io.IOException;

import org.apache.catalina.Valve;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthenticationFilter extends BaseFilter {
	
	private boolean valve = false;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(valve) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession hs =req.getSession();
			User user = (User)hs.getAttribute("user");
			
			if(user!=null) {
				log(user.getId()+"has logged in");
				chain.doFilter(request, response);
			}else {
				HttpServletResponse res =(HttpServletResponse) response;
				res.getWriter().println("Please log in");
			} 
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		String sValve = filterConfig.getInitParameter("valve");
		
		if(sValve!=null) {
			if(sValve.equals("on")) {
				valve=true;
			}else if(sValve.equals("off")) {
				valve=false;
			}
		}
			log("init AuthemticationFilter("+sValve+")");
	}

}