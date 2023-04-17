package listener;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
// – Ghi nhận số lượng truy 
@WebListener
public class AppListener implements HttpSessionListener, ServletContextListener {
	// Chạy ngay khi 1 phiên làm việc được tạo 
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		Integer visitors = (Integer) application.getAttribute("visitors");
		application.setAttribute("visitors", visitors + 1);
	}

	// Chạy ngay trước khi làm việc hết hạn
	public void sessionDestroyed(HttpSessionEvent se) {}

	// Chạy sau khi ứng dụng khởi động 
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		Integer visitors = 0;
		try {
			String path = application.getRealPath("../SOF3011.AssignmentFinal/src/visitors.txt"); // đặt tại webroot
			List<String> lines = Files.readAllLines(Paths.get(path));
			visitors = Integer.valueOf(lines.get(0));
		} catch (Exception e2) {
			visitors = 0; // khởi đầu số khách
		}
		application.setAttribute("visitors", visitors);
	}

	// Chạy trước khi ứng dụng web bị shutdown
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		Integer visitors = (Integer) application.getAttribute("visitors");
		try {
			String path = application.getRealPath("../SOF3011.AssignmentFinal/src/visitors.txt");
			byte[] data = String.valueOf(visitors).getBytes();
			Files.write(Paths.get(path), data, StandardOpenOption.CREATE);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
