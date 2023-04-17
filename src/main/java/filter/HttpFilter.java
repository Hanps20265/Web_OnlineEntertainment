package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Class dùng để ép kiều từ ServletRequest, ServletResponse => HttpServletRequest, HttpServletResponse
public interface HttpFilter extends Filter {
	
	@Override
	default void init(FilterConfig fConfig) throws ServletException {}

	@Override
	default void destroy() {}
	
	@Override
	default void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		this.doFilter(req, resp, chain);
	}
	
	void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException;
}
