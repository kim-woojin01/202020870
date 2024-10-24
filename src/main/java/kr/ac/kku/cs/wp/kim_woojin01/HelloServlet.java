package kr.ac.kku.cs.wp.kim_woojin01;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private String greeting = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		greeting = config.getInitParameter("greeting");
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log("Hello Servlet");
		String html = """
				<html>
				<head></head>
				<body>
				"""+greeting+"""
				<body>
				<html>
				""";
		res.getWriter().println(html);
	}

	@Override
	public void destroy() {
		log("Hello was destroyed");
		super.destroy();
	}

}