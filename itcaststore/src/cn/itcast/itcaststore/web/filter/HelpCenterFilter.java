package cn.itcast.itcaststore.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.User;

/**
 * Servlet Filter implementation class HelpCenterFilter
 */
public class HelpCenterFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
       HttpServletRequest req=(HttpServletRequest) request;
       HttpServletResponse resp= (HttpServletResponse) response;
		// pass the request along the filter chain
       User user=(User) req.getSession().getAttribute("user");
       if(user!=null)
		chain.doFilter(request, response);
       else{
       resp.sendRedirect(req.getContextPath() + "/client/login.jsp");
       }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
