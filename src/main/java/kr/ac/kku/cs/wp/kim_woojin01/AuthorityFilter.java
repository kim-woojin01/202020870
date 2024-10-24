package kr.ac.kku.cs.wp.kim_woojin01;

import java.io.IOException;

import javax.print.attribute.HashDocAttributeSet;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/jsp/admin/*")
public class AuthorityFilter extends BaseFilter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession hs =req.getSession(false);
		User user=(User)hs.getAttribute("user");
		String role = user.getRole();
		
		if(!role.equals("admin")) {
			HttpServletResponse res=(HttpServletResponse) response;
			res.getWriter().print("Admin access only");
		}else {
			chain.doFilter(request, response);
		}
	}

}