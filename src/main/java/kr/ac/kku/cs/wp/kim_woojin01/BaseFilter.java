package kr.ac.kku.cs.wp.kim_woojin01;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public abstract class BaseFilter implements Filter {
	
	private String filterName = null;
	private ServletContext servletContext;
	
	protected void log(String message) {
		String sm = filterName+":"+message;
		servletContext.log(sm);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		filterName = filterConfig.getFilterName();
		servletContext=filterConfig.getServletContext();
	}
	

}