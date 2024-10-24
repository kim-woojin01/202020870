package kr.ac.kku.cs.wp.kim_woojin01;

import java.io.IOException;

import javax.print.attribute.HashDocAttributeSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession hs = req.getSession();
		User sUser =(User)hs.getAttribute("user");
		
		if(sUser==null) {
			String id = req.getParameter("id");
			String role = req.getParameter("role");
			
			
			User user = new User();
			user.setId(id);
			user.setRoles(role);
			hs.setAttribute("user", user);
			
			log(user.getId());
			log(user.getRole());
			
			res.getWriter().println("Login successful");
		}else {
			res.getWriter().println(sUser.getId()+"!please log out first");
		}
	}

}