package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.XCookie;
import utils.XScope;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.apache.commons.beanutils.BeanUtils;

import dao.FavoriteDAO;
import dao.ShareDAO;
import dao.UserDAO;
import dao.VideoDAO;
import entity.Favorites;
import entity.Shared;
import entity.Users;
import entity.Videos;

@WebServlet({ "/home", "/my-favorite",
	"/index/control/next", "/index/control/back", "/index/control/first", "/index/control/last",
	"/sign-in", "/sign-up", "/forgot-password", 
	"/sign-out", "/change-password", "/edit-profile",  
	"/video/like/*", "/video/share/*", "/video/detail/*", "/detail/like/*", "/detail/share/*",
	"/detail/control/next", "/detail/control/back",  "/detail/control/first", "/detail/control/last"
})
public class MenuServlet extends HttpServlet {
	/* Khai báo biến toàn cục*/
	private static final long serialVersionUID = 1L;
	VideoDAO videoDao = new VideoDAO();
	UserDAO userDAO = new UserDAO();
	FavoriteDAO favoriteDAO = new FavoriteDAO();
	ShareDAO shareDAO  = new ShareDAO();
	String titleList = "";
	String alert = "";
	int lenght;
	int start = 0, size = 6;
	List<Videos> listVAll = new ArrayList<Videos>();
	List<Videos> listV = new ArrayList<Videos>();

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		listVAll = videoDao.findAll();
		titleList = "Danh sách Video được xem nhiều nhất!";
		alert = ""; 
//		listV = null;
		String uri = request.getRequestURI();
//		start = 0; size = 6; 
//		listV = videoDao.findPage(start, size);
		if (uri.contains("home")) {
			start = 0; size = 6;
			listV = videoDao.findPage(start, size);
			this.showList(request, response);
			XScope.setSession("page", "/views/ListVideos.jsp");
				
		} else 
			if (uri.contains("sign-in")) {
				if(this.doSignIn(request, response)) {
					start = 0; size = 6;
		        	listV = videoDao.findPage(start, size);
		        	this.showList(request, response);
		        	XScope.setSession("page", "/views/ListVideos.jsp");
				} else 
					XScope.setSession("page", "/views/account/SignIn.jsp");
		} else 
			if (uri.contains("video/like")) {
				this.doLike(request, response);
				listV = videoDao.findPage(start, size);
				this.showList(request, response);
				XScope.setSession("page", "/views/ListVideos.jsp");	
		} else 
			if (uri.contains("video/share")) {
				if(this.doShare(request, response)) {
					listV = videoDao.findPage(start, size);
					this.showList(request, response);
					XScope.setSession("page", "/views/ListVideos.jsp");
				} else XScope.setSession("page", "/views/Share.jsp");
		} else 
			if (uri.contains("index/control")) {
				lenght = listVAll.size();
				if (uri.contains("next")) {
					this.next();	
				} else if (uri.contains("back")) {
					this.prev();
				} else if (uri.contains("first")) {
					this.first();
				} else if (uri.contains("last")) {
					this.last();
				} 
				listV = videoDao.findPage(start, size);
				this.showList(request, response);
				XScope.setSession("page", "/views/ListVideos.jsp");
		} else 
			if (uri.contains("detail/like")) {
				this.doLike(request, response);
				listV = videoDao.findPage(start, size);
				this.showList(request, response);
				XScope.setSession("page", "/views/Detail.jsp");	
		} else 
			if (uri.contains("detail/share")) {
				if(this.doShare(request, response)) {
					listV = videoDao.findPage(start, size);
					this.showList(request, response);
					XScope.setSession("page", "/views/Detail.jsp");
				} else XScope.setSession("page", "/views/Share.jsp");
		} else 
			if (uri.contains("video/detail")) {
				start = 0; size = 6; 
				listV = videoDao.findPage(start, size);
				this.showList(request, response);
				String videoId = XScope.request().getParameter("videoId");
				Videos video = videoDao.findById(videoId);
				XScope.setSession("video", video); 
				XScope.setSession("page", "/views/Detail.jsp");
		} else 
			if (uri.contains("detail/control")) {
				lenght = listVAll.size();
				if (uri.contains("next")) {
					this.next();
				} else if (uri.contains("back")) {
					this.prev();				
				} else if (uri.contains("first")) {
					this.first();			
				} else if (uri.contains("last")) {
					this.last();
				}
				listV = videoDao.findPage(start, size);
				this.showList(request, response);
				XScope.setSession("page", "/views/Detail.jsp");
		} else
			if (uri.contains("my-favorite")) {
				this.myFavorite(request, response);
				this.showList(request, response);
				XScope.setSession("page", "/views/ListVideos.jsp");
		} else
			if (uri.contains("sign-up")) {
				if(this.doSignUp(request, response)) {
					XScope.setSession("page", "/views/account/SignIn.jsp");
				} else XScope.setSession("page", "/views/account/SignUp.jsp");
			} else 
			if (uri.contains("forgot-password")) {
				if(this.doForgotPassword(request, response)) {
					XScope.setSession("page", "/views/account/SignIn.jsp");
				} else XScope.setSession("page", "/views/account/ForgotPassword.jsp");	
		} else 
			if (uri.contains("sign-out")) {
				XScope.setSession("authUser", null);
				XScope.setSession("page", "/views/account/SignIn.jsp");	
		} else 
			if (uri.contains("change-password")) {
				if(this.doChangePassword(request, response)) {
					XScope.setSession("authUser", null);
					XScope.setSession("page", "/views/account/SignIn.jsp");
				} else XScope.setSession("page", "/views/account/ChangePassword.jsp");
		} else 
			if (uri.contains("edit-profile")) {
				this.doEditProfile(request, response);
				XScope.setSession("page", "/views/account/EditProfile.jsp");
		} 
		
		XScope.setRequest("alert", alert);
		XScope.setRequest("titleList", titleList);
		request.getRequestDispatcher("/views/Layout_Custom.jsp").forward(request, response);
	}

	public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Users user = XScope.getSession("authUser");
		if(user != null) { 
			List<Videos> listF = videoDao.findVideosFavoritedByUserID(user.getUserId());
			XScope.setRequest("listF", listF); /* Những video nào được like sẽ hiển thị Unlike, ngược lại hiển thị Like */
//			System.out.println("ListF: "+ listF.get(0).getTitle());
		}
		XScope.setRequest("listV", listV);
	}

	private void myFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Users user = XScope.getSession("authUser");
		if(user!=null) {
			listV = videoDao.findVideosFavoritedByUserID(user.getUserId());
			if(listV !=null) {
				titleList = "CÁC VIDEO YÊU THÍCH CỦA BẠN!";
			} else {
				alert = "Bạn chưa có video yêu thích nào!";
			}	
		} 
	}

	private boolean doSignIn(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("GET")){
			String username = XCookie.get("username", ""); 
	    	String password = XCookie.get("password", "");
	    	XScope.setRequest("username", username);
	    	XScope.setRequest("password", password);
		} else if (method.equalsIgnoreCase("POST")) {
			String id = request.getParameter("username");
			if(id.trim().length() == 0) {
				alert = "Tên đăng nhập không được để trống!";
				return false;
			}
			Users user = new Users();
			user = userDAO.findById(id);
			if(user==null) {
				alert = "Sai tên đăng nhập!";
				return false;
			}
			String pw = request.getParameter("password");
			if(pw.length() == 0) {
				alert = "Mật khẩu không được để trống!";
				return false;
			}
			String rem = request.getParameter("remember");
			try {	
				if (!user.getPassword().equals(pw)) {
					alert = "Sai mật khẩu!";	
				} else {
					alert = "Xin Chào "+user.getFullname()+"!";
					XScope.setSession("authUser", user);
		        	/* Save cookie */
					int hours = (rem == null) ? 0 : 30*24;
		        	XCookie.add("username", id, hours); 
		        	XCookie.add("password", pw, hours);
		        	return true;
				}
			} catch (Exception e) {
				alert = "Đăng nhập thất bại!";
				e.printStackTrace();	
			}
		}
		return false;
	}

	private boolean doSignUp(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String method = XScope.request().getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				
				String username = XScope.request().getParameter("userId");
				if(username.length() == 0) {
					alert = "Username không được để trống";
					return false;
				}
				Users user = userDAO.findById(username);
				if(user != null ) {
					alert = "Người dùng này đã tồn tại";
					return false;
				}
				user = new Users();
				BeanUtils.populate(user, request.getParameterMap());
				userDAO.create(user);
				alert = "Đăng ký thành công!";
				return true;
			} catch (Exception e) {
				alert = "Lỗi đăng ký!";
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean doForgotPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("POST")){
			String subject = "Cấp lại mật khẩu mới!";
			String from = "hanlnnps20265@fpt.edu.vn";
			String pass = "pbhjpmmcyqqlrxio";
			String username = XScope.request().getParameter("username").trim();

			if(username.equals("")) {
				alert = "Username của bạn không được để trống!";
				return false;
			}
			Users u = userDAO.findById(username);
			if(u == null) {
				alert = "Username của bạn không tồn tại!";
				return false;
			}
			String to = XScope.request().getParameter("email").trim();
			if(to.length() == 0) {
				alert = "Email của bạn không được để !";
				return false;
			}

			String newpass = "";
	        for (int i = 0; i < 10; i++) {
	        	newpass = String.valueOf((Math.random() * 10) + 1);
	        }
			String body = "Chào bạn "+ u.getFullname()
							+ "\nMật khẩu mới của bạn là: " + newpass 
							+"\nVui lòng không cung cấp mật khẩu cho bất cứ ai!"
							+"\nĐể an toàn, bạn nên đổi lại mật khẩu mới cho mình.";
			try {
		        Properties p = new Properties();
		        p.put("mail.smtp.auth", "true");
		        p.put("mail.smtp.starttls.enable", "true");
		        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		        p.put("mail.smtp.host", "smtp.gmail.com");
		        p.put("mail.smtp.port", 587);
		        Session s = Session.getInstance(p,
		             new javax.mail.Authenticator() {
		             	protected PasswordAuthentication getPasswordAuthentication() {
		             		return new PasswordAuthentication(from, pass);
		             }
		        });
		        Message msg = new MimeMessage(s);
		        msg.setFrom(new InternetAddress(from));
		        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		        msg.setSubject(subject);
		        msg.setText(body);
		        MimeBodyPart content = new MimeBodyPart();
	            content.setContent(body, "text/html; charset=utf-8");
		        Transport.send(msg);
		        alert = "Mail was sent successfully";
		        
		        /* Lưu passnew sau khi đã mail thành công */
		        Users user = userDAO.findById(username);
		        user.setPassword(newpass);
		        userDAO.update(user);   
		        return true;
		     } catch (Exception e) {
		    	 alert = "Mail wasn't sent successfully";
		    	 e.printStackTrace();
		     }
		}
		return false;
	}
	
	private boolean doChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = XScope.request().getMethod();
		
		if(method.equalsIgnoreCase("POST")){
			Users user = XScope.getSession("authUser");
			String oldpass = XScope.request().getParameter("password");
			String newpass = XScope.request().getParameter("newpass");
			String confirm = XScope.request().getParameter("confirm");
			if (oldpass == null || (!oldpass.matches(user.getPassword())) ){
				alert = "Mật khẩu hiện tại bạn nhập chưa đúng, vui lòng nhập lại!";
				return false;
			} else if(!newpass.matches(confirm) || newpass == null) {
				alert = "Mật khẩu xác nhận lại không khớp với mật khẩu mới!";
				return false;
			} else {
				alert = "Bạn đã thay đổi mật khẩu mới thành công!";
				user.setPassword(newpass);
				userDAO.update(user);
				return true;
			}
		}
		return false;
	}
	
	private void doEditProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = XScope.request().getMethod();
		if (method.equalsIgnoreCase("POST")) {
			Users user = new Users();
			user = XScope.getSession("authUser");
			try {
				BeanUtils.populate(user, request.getParameterMap());
				userDAO.update(user);
				alert = "Cập nhật tài khoản thành công!";
				XScope.setSession("authUser", user);
			} catch (Exception e) {
				alert = "Lỗi cập nhật tài khoản!";
				e.printStackTrace();
			}
		}
	}
	
	private void doLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = XScope.request().getMethod();

		if(method.equalsIgnoreCase("POST")){
			String videoId = XScope.request().getParameter("videoId");
			String varLike = XScope.request().getParameter("varLike");
			Users user = new Users();
			user = XScope.getSession("authUser");
			Videos video = videoDao.findById(videoId);
			if(varLike.equals("Like")) {
				Date likeDate = new Date();
				Favorites favorites = new Favorites(user, video, likeDate);
				favoriteDAO.create(favorites);
				
			} else if(varLike.equals("Unlike")) {
				Favorites favorites = favoriteDAO.findOne(videoId, user.getUserId());
				favoriteDAO.remove(String.valueOf(favorites.getFavoriteId()));
			}
		}
	}

	private boolean doShare(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{	
		String method = XScope.request().getMethod();
		String videoId = XScope.request().getParameter("videoId");
		if(method.equalsIgnoreCase("POST")){
			XScope.setRequest("videoId", videoId);
		}
		if(method.equalsIgnoreCase("GET")){
			Users user = new Users();
			user = XScope.getSession("authUser");
			String from = "hanlnnps20265@fpt.edu.vn";
			String pass = "pbhjpmmcyqqlrxio";
			String to = XScope.request().getParameter("email").trim();
			if(to.length() == 0) {
				alert = "Email của bạn không được để trống!";
				return false;
			}
			if(videoId == null) {
				alert = "Không tìm thấy videoId!";
				return false;
			}
			String subject = "Cùng "+user.getFullname()+" nghe những bài hát hay nhé !";
			String body = "Nhấn vào link: SOF3011.AssignmentFinal/video/share?shareId="+videoId;
			try {
				Properties p = new Properties();
		        p.put("mail.smtp.auth", "true");
		        p.put("mail.smtp.starttls.enable", "true");
		        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		        p.put("mail.smtp.host", "smtp.gmail.com");
		        p.put("mail.smtp.port", 587);
		        Session s = Session.getInstance(p,
	                 new javax.mail.Authenticator() {
	             		protected PasswordAuthentication getPasswordAuthentication() {
	             			return new PasswordAuthentication(from, pass);
	             		}
		        });
		        Message msg = new MimeMessage(s);
		        msg.setFrom(new InternetAddress(from));
		        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		        msg.setSubject(subject);
		        msg.setText(body);
		        MimeBodyPart content = new MimeBodyPart();
	            content.setContent(body, "text/html; charset=utf-8");
	            Transport.send(msg);
		        
		         
		        Videos video = videoDao.findById(videoId);
		        if(video==null) {
		        	alert = "Không tìm thấy Video!";
		        	return false;
		        }
		        Date dateShared = new Date();
		        Shared share = new Shared(user, video, dateShared);
		        shareDAO.create(share);
		        alert = "Mail was sent successfully";
		        return true;
			} catch (Exception e) {
				alert = "Mail wasn't sent successfully";
				e.printStackTrace();
			}
		}
		return false;
	}

	protected void first() {
		start = 0;
	}
	
	protected void next() {
		start += size; 
		if(lenght==start){ 
			start = lenght - start; 
		} else if (lenght<start){
			start = 0;
		}
	}

	protected void prev() {
		start -= size;
		if(start<0){
			last();
		}
	}
	
	protected void last() {
		start = lenght-lenght%size;
		System.out.println(lenght);
		System.out.println("start: "+ start);
		if(lenght==start){ 
			start = lenght - size; 
			System.out.println(start);
		} 
	}

}
