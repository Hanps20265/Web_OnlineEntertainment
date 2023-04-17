package filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.RRSharer;
import java.io.IOException;

@WebFilter(filterName="AppFilter", urlPatterns="/*")
public class AppFilter implements HttpFilter {
	/* Chạy sau khi giải */
	public void destroy() {
		RRSharer.remove();
	}
	/* Chạy trước khi nạp vào */
	public void init(FilterConfig fConfig) throws ServletException {}

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		RRSharer.add(req, resp);
		String lang = req.getParameter("lang");
		if (lang!=null) req.getSession().setAttribute("lang", lang);
		chain.doFilter(req, resp);
	}
}
