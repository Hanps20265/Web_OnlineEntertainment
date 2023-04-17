package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utils.XScope;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import dao.ReportDAO;
import dao.UserDAO;
import dao.VideoDAO;
import entity.Report;
import entity.Users;
import entity.Videos;

@MultipartConfig()
@WebServlet({ "/admin/*", "/report",
	"/manage-videos",
	"/Video/create", "/Video/reset", "/Video/edit/*", "/Video/update", "/Video/delete", 
	"/Video/control/next", "/Video/control/prev", "/Video/control/first", "/Video/control/last",
	"/manage-users", 
	"/User/edit/*", "/User/update", "/User/delete", 
	"/User/control/next","/User/control/prev", "/User/control/first", "/User/control/last",
})

public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
	VideoDAO videoDao = new VideoDAO();
	// Tạo list
	List<Users> listU = new ArrayList<Users>();
	List<Users> listUAll = new ArrayList<Users>();
	List<Videos> listVAll = new ArrayList<Videos>();
	List<Videos> listV = new ArrayList<Videos>();
	String titleList = "";
	int lenght;
	int start = 0, size = 6; // List ban đầu hiển thị 6 User or Video đầu tiên
	String alert="";
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Lấy danh sách hiện tại của User và Video
		listUAll = userDAO.findAll();
		listVAll = videoDao.findAll();
		titleList = "Danh sách Video được xem nhiều nhất!";
		alert=""; listV = null; 
		String uri = request.getRequestURI(); // lấy đường dẫn 
	
		if (uri.contains("admin")) {
			start = 0; size = 6;
			listV = videoDao.findPage(start, size);
			this.showList(request, response);
			XScope.setSession("page", "/views/ListVideos.jsp");
		} else 
			if (uri.contains("manage-videos")) {
				start = 0; size = 6;
				this.manageVideos(request, response);
				
				XScope.setRequest("tabVideo1", "/views/tabVideoEdition.jsp");
				XScope.setRequest("tabVideo2", "/views/tabVideoList.jsp");
		} else 
			if (uri.contains("manage-users")) {
				start = 0; size = 6;
				this.manageUsers(request, response);
				XScope.setRequest("tabUser1", "/views/tabUserEdition.jsp");
				XScope.setRequest("tabUser2", "/views/tabUserList.jsp");
		} else 
			if (uri.contains("report")) {
				this.report(request, response);
				
		}else 
			if (uri.contains("User/edit")) {
				this.doEdit(request, response);
				this.manageUsers(request, response);
				XScope.setRequest("tabUser1", "/views/tabUserEdition.jsp");
				XScope.setRequest("tabUser2", "/views/tabUserList.jsp");
			
		} else if (uri.contains("User/update")) {
			this.doUpdate(request, response);
			this.manageUsers(request, response);
			XScope.setRequest("tabUser1", "/views/tabUserEdition.jsp");
			XScope.setRequest("tabUser2", "/views/tabUserList.jsp");
			
		} else if (uri.contains("User/delete")) {
			this.delete(request, response);
			this.manageUsers(request, response);
			XScope.setRequest("tabUser1", "/views/tabUserEdition.jsp");
			XScope.setRequest("tabUser2", "/views/tabUserList.jsp");
			
		} else if (uri.contains("User/control/next")) {
			lenght = listUAll.size(); // 16
			this.next();
			XScope.setRequest("userEdition", "show");
			XScope.setRequest("tabUser2", "/views/tabUserEdition.jsp");
			XScope.setRequest("tabUser1", "/views/tabUserList.jsp");
			this.manageUsers(request, response);
			
		} else if (uri.contains("User/control/prev")) {
			lenght = listUAll.size(); // 16
			this.prev();
			XScope.setRequest("userEdition", "show");
			XScope.setRequest("tabUser2", "/views/tabUserEdition.jsp");
			XScope.setRequest("tabUser1", "/views/tabUserList.jsp");
			this.manageUsers(request, response);
			
		} else if (uri.contains("User/control/first")) {
			lenght = listUAll.size(); // 16
			this.first();
			XScope.setRequest("userEdition", "show");
			XScope.setRequest("tabUser2", "/views/tabUserEdition.jsp");
			XScope.setRequest("tabUser1", "/views/tabUserList.jsp");
			this.manageUsers(request, response);
			
		} else if (uri.contains("User/control/last")) {
			lenght = listUAll.size(); // 16
			this.last();
			XScope.setRequest("userEdition", "show");
			XScope.setRequest("tabUser2", "/views/tabUserEdition.jsp");
			XScope.setRequest("tabUser1", "/views/tabUserList.jsp");
			this.manageUsers(request, response);
			
		} else 
			if (uri.contains("Video/create")) {
			this.doCreateVideo(request, response);
			XScope.setRequest("tabVideo1", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo2", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/reset")) {
			this.manageVideos(request, response);
			XScope.setRequest("tabVideo1", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo2", "/views/tabVideoList.jsp");
			this.doResetVideo(request, response);
			
		} else if (uri.contains("Video/edit")) {
			this.doEditVideo(request, response);
			XScope.setRequest("tabVideo1", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo2", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/update")) {
			this.doUpdateVideo(request, response);
			XScope.setRequest("tabVideo1", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo2", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/delete")) {
			this.deleteVideo(request, response);
			XScope.setRequest("tabVideo1", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo2", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/control/next")) {
			lenght = listVAll.size();
			this.next();
			XScope.setRequest("videoEdition", "show");
			XScope.setRequest("tabVideo2", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo1", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/control/prev")) {
			lenght = listVAll.size();
			this.prev();
			XScope.setRequest("videoEdition", "show");
			XScope.setRequest("tabVideo2", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo1", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/control/first")) {
			lenght = listVAll.size();
			this.first();
			XScope.setRequest("videoEdition", "show");
			XScope.setRequest("tabVideo2", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo1", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		} else if (uri.contains("Video/control/last")) {
			lenght = listVAll.size();
			this.last();
			XScope.setRequest("videoEdition", "show");
			XScope.setRequest("tabVideo2", "/views/tabVideoEdition.jsp");
			XScope.setRequest("tabVideo1", "/views/tabVideoList.jsp");
			this.manageVideos(request, response);
			
		}
		XScope.setRequest("alert", alert);
		request.getRequestDispatcher("/views/Layout_Staff.jsp").forward(request, response);
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

	private void manageVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listV = videoDao.findPage(start, size);
		this.showList(request, response);
		XScope.setSession("sumVideos", listVAll.size());
		XScope.setSession("page", "/views/Manage_Video.jsp");
	}

	private void manageUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listU = userDAO.findPage(start, size);
		XScope.setRequest("listU", listU);
		XScope.setSession("sumUsers", listUAll.size());
		System.out.println("listUAll.size(): "+listUAll.size());
		XScope.setSession("page", "/views/Manage_User.jsp");
	}
	
	private String getImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File dir = new File(request.getServletContext().getRealPath("/public")); 
		if(!dir.exists()) { 
			dir.mkdirs(); 
		}
		Part photo = request.getPart("poster"); 
		try {
			File photoFile = new File(dir, photo.getSubmittedFileName()); 
			photo.write(photoFile.getAbsolutePath());
			// System.out.println("Name1: "+ photo.getSubmittedFileName());
			// System.out.println("Name: "+ photoFile.getAbsolutePath());
			return photoFile.getName();
		} catch (Exception e){
			e.getMessage();
		}
		return null;
	}

	private void doCreateVideo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("POST")){
			try {
				String id = request.getParameter("videoId");
				if(id.length()==0) {
					alert="Video không được để trống!";
					return;
				}
				Videos video  = videoDao.findById(id);
				if(video != null) {
					alert="Video đã tồn tại!";
					XScope.setRequest("video", video);
					return;
				}
				video = new Videos();
				video.setVideoId(id);
				String poster = this.getImage(request, response);
				if(poster == null){
					alert = "Poster chưa được thêm vào!";
					return;
				}
				video.setPoster(poster);
				String title = request.getParameter("title");
				video.setTitle(title);
				String view = request.getParameter("view");
				video.setViews(Integer.parseInt(view));
				String active = request.getParameter("active");
				video.setActive(Boolean.parseBoolean(active));
				String descriptions = request.getParameter("descriptions");
				video.setDescriptions(descriptions);
				videoDao.create(video);
				XScope.setRequest("video", video);
				alert="Đã thêm video thành công!";
				
				listVAll = videoDao.findAll();
				start=0; size = 6;
				this.showList(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				alert="Thêm video thất bại!";
			}
		}
	}

	private void doResetVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("POST")){
			Videos video = new Videos();
			XScope.setSession("video", video);	
		}
	}
	
	private void doEditVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		Videos video = videoDao.findById(id);
		XScope.setRequest("video", video);
	}

	private void doUpdateVideo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("POST")){
			try {
				String id = request.getParameter("videoId");
				if(id.equals("")) {
					alert="VideoId đang được để trống!";
					return;
				}
				Videos video = videoDao.findById(id);
				if(video == null) {
					alert="Video không tồn tại!";
					return;
				}
				if (request.getPart("poster").getSize() == 0) {
					video.setPoster(video.getPoster());
				} else {
					video.setPoster(this.getImage(request, response));
				}
				
				String title = request.getParameter("title");
				video.setTitle(title);
				String view = request.getParameter("view");
				video.setViews(Integer.parseInt(view));
				String active = request.getParameter("active");
				video.setActive(Boolean.parseBoolean(active));
				String descriptions = request.getParameter("descriptions");
				video.setDescriptions(descriptions);
				
				videoDao.update(video);
				alert="Video đã được Update thành công!";
				XScope.setRequest("video", video);
				start=0; size = 6;
				this.showList(request, response);
				
			} catch (Exception e) {
				System.out.println(e);
				alert="Video chưa được Update!";
			}
		}
	}

	private void deleteVideo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("POST")){
			try {
				String id = request.getParameter("videoId");
				if(id.equals("")) {
					alert="VideoId đang được để trống!";
					return;
				}
				Videos v = videoDao.findById(id);
				if(v==null) {
					alert="Video không tồn tại!";
					return;
				}
				videoDao.remove(id);
				XScope.setRequest("video", null);
				alert="Video đã được xóa thành công!";
				listVAll = videoDao.findAll();
			
			} catch (Exception e) {
				alert="Video đã được xóa thất bại!";
				e.printStackTrace();
			}
		}
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = XScope.request().getMethod();
		if(method.equalsIgnoreCase("POST")){
			try {
				String id = request.getParameter("userId");
				if(id.equals("")) {
					alert="UserId đang được để trống!";
					return;
				}
				Users u = userDAO.findById(id);
				if(u == null) {
					alert="User không tồn tại!";
					return;
				}
				
				Users user = new Users();
				BeanUtils.populate(user, request.getParameterMap());
				userDAO.update(user);
				alert="User đã được Update thành công!";
				XScope.setRequest("user", user);
			} catch (Exception e) {
				System.out.println(e);
				alert="User Update thất bại!";
			}
		}
	}
	
	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		Users u = userDAO.findById(id);
		XScope.setRequest("user", u);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		String method = XScope.request().getMethod();
			if(method.equalsIgnoreCase("POST")){
			try {
				String id = request.getParameter("userId");
//				System.out.println("ID: "+id);
				if(id.equals("")) {
					alert="UserId đang được để trống!";
					return;
				}
				Users u = userDAO.findById(id);
				if(u==null) {
					alert="User không tồn tại!";
					return;
				}
				userDAO.remove(id);
				XScope.setRequest("user", null);
				alert="User đã được xóa thành công!";
				listUAll = userDAO.findAll();
				
			} catch (Exception e) {
				e.printStackTrace();
				alert="User xóa thất bại!";
			}
		}
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

	private void report(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportDAO rDao = new ReportDAO();
		// tab Favorite
		XScope.setRequest("report", true);
		List<Report> listR = rDao.report_JPQL();
		XScope.setRequest("listR", listR);
		XScope.setRequest("listVAll", listVAll);
		
		// tab User List
		String title = request.getParameter("title");
		List<Object[]> listUser = new ArrayList<Object[]>();
		System.out.println(title);
		
		if(title != null) {
			listUser = rDao.findUsersFavoritedByVideoTitle(title);
//				for(Object[] i: listUser ) {
//					System.out.println("User: ");
//					System.out.println(i[0]);
//					System.out.println(i[1]);
//					System.out.println(i[2]);
//					System.out.println(i[3]);
//				}
		} else {
			listUser = rDao.findUsersFavorited();
		}
		XScope.setRequest("listUser", listUser);
		
		//tab Shared Friends
		String titleShared = request.getParameter("titleShared");
		List<Object[]> listUserShared = new ArrayList<Object[]>();
		System.out.println(titleShared);
		if(titleShared != null) {
			listUserShared = rDao.findUsersSharedByVideoTitle(titleShared);
//				for(Object[] i: listUserShared ) {
//					System.out.println("User: ");
//					System.out.println(i[0]);
//					System.out.println(i[1]);
//					System.out.println(i[2]);
//					System.out.println(i[3]);
		} else {
			listUserShared = rDao.findUsersShared();
		}
			XScope.setRequest("listUserShared", listUserShared);
			XScope.setSession("page", "/views/Report.jsp");
	}
}
