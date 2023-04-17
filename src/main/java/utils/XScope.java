package utils;
// Cung cấp các phương thức đọc/ghi attribute trong các scope

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class XScope {
	
	/* Tham chiếu scope trong servlet
 	HttpSession session = request.getSession()
	ServletContext application = this.getServletContext()
	ServletContext application = request.getServletContext()
	ServletContext application = session.getServletContext()
	*/
	public static HttpServletRequest request() {
		return RRSharer.request(); 
	}
	public static HttpServletResponse response() {
		return RRSharer.response(); 
	}
	// Tham chiếu đến Session
	public static HttpSession session() {
		return request().getSession(); 
	}
	// Tham chiếu đến Application
	public static ServletContext application() { 
		return request().getServletContext();
	}
	
	/* REQUEST API*/
	// Tạo attribute trong REQUEST scope (@param "name" tên attribute, @param "value" giá trị của attribute)
	public static void setRequest(String name, Object value) {
		request().setAttribute(name, value); 
	}
	// Đọc attribute trong REQUEST scope * @param "name" tên attribute
	@SuppressWarnings("unchecked")
	public static <T> T getRequest(String name) {
		return (T) request().getAttribute(name); } //@return Giá trị của attribute hoặc null nếu không tồn tại
	//Xóa attribute trong REQUEST scope (@param "name" tên attribute cần xóa)
	public static void removeRequest(String name) { 
		request().removeAttribute(name);
	}
	
	
	/* SESSION API*/
	// Tạo attribute trong SESSION scope (@param "name" tên attribute, @param "value" giá trị của attribute)
	public static void setSession(String name, Object value) {
		session().setAttribute(name, value); 
	}
	// Đọc attribute trong SESSION scope * @param "name" tên attribute
	@SuppressWarnings("unchecked")
	public static <T> T getSession(String name) {
		return (T) session().getAttribute(name); } //@return Giá trị của attribute hoặc null nếu không tồn tại
	//Xóa attribute trong SESSION scope (@param "name" tên attribute cần xóa)
	public static void removeSession(String name) {
		session().removeAttribute(name); }
	
	
	/* APPLICATION API*/
	// Tạo attribute trong APPLICATION scope (@param "name" tên attribute, @param "value" giá trị của attribute)
	public static void setApplication(String name, Object value) {
		application().setAttribute(name, value); }
	// Đọc attribute trong APPLICATION scope * @param "name" tên attribute
	@SuppressWarnings("unchecked")
	public static <T> T getApplication(String name) {
		return (T) application().getAttribute(name); } // @return Giá trị của attribute hoặc null nếu không tồn tại 
	/*Xóa attribute trong APPLICATION scope * @param "name" tên attribute cần xóa */
	public static void removeApplication(String name) {
		application().removeAttribute(name); 
	}
		
}
