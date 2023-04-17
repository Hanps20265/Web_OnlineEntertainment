package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.XScope;

import java.io.IOException;

import entity.Users;


/* AuthFilter 
 – Bảo mật chức năng
 – Ghi nhận lịch sử truy xuất
 */
@WebFilter(filterName="AuthFilter", urlPatterns={ "/video/like/*", "/video/share/*", "/my-favorite", "/admin/*"}) 
public class AuthFilter implements HttpFilter {
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) 
			throws IOException, ServletException {
		String uri = XScope.request().getRequestURI();
		Users user = XScope.getSession("authUser"); 
		String message = "";
		
		if(user == null) {
			message = XScope.response().encodeURL("Please sign-in!");
		} else if(!user.getAdmin() && uri.contains("/manage")) {
			message = XScope.response().encodeURL("Please sign-in using admin account!");
		}
		
		if(!message.isEmpty()) {
			XScope.setSession("securi", uri); 
			XScope.response().sendRedirect("/SOF3011.AssignmentFinal/sign-in?error="+XScope.response().encodeURL(message));
		} else {
			chain.doFilter(req, resp);
		}
	}
}
