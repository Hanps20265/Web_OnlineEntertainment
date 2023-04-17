package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.ConvertUtils;
//import org.apache.commons.beanutils.converters.DateConverter;
//import org.apache.commons.beanutils.converters.DateTimeConverter;

import jakarta.servlet.http.Part;

public class XForm {
	// Kiểm tra sự tồn tại của tham số (truyền tham dưới dang String) => @param "name" tên tham số
	public static boolean exist(String name) {
		return RRSharer.request().getParameter(name) != null;  //@return true nếu tồn tại, ngược lại là false
	}

	// Đọc CHUỖI từ tham số form (@param "name" tên tham số form, @param "defval" giá trị mặc định)
	public static String getString(String name, String defval) {
		String value = RRSharer.request().getParameter(name);
		return value == null ? defval : value; // @return Giá trị tham số hoặc defval nếu tham số không tồn tại
	}

	// Đọc SỐ NGUYÊN từ tham số form (@param "name" tên tham số form, @param "defval" giá trị mặc định)
	public static int getInt(String name, int defval) {
		String value = getString(name, String.valueOf(defval));
		return Integer.parseInt(value); // @return Giá trị tham số hoặc defval nếu tham số không tồn tại,parseInt trước khi @return
	}

	// Đọc SỐ THỰC từ tham số form (@param "name" tên tham số form, @param "defval" giá trị mặc định)
	public static double getDouble(String name, double defval) {
		String value = getString(name, String.valueOf(defval));
		return Double.parseDouble(value); // @return Giá trị tham số hoặc defval nếu tham số không tồn tại,parseDouble trước khi @return
	}

	// Đọc giá trị BOOLEAN từ tham số form (@param "name" tên tham số form, @param "defval" giá trị mặc định)
	public static boolean getBoolean(String name, boolean defval) {
		String value = getString(name, String.valueOf(defval));
		return Boolean.parseBoolean(value); // @return Giá trị tham số hoặc defval nếu tham số không tồn tại,parseBoolean trước khi @return
	}

	// Đọc thời gian DATE từ tham số form (@param "name" tên tham số form, @param "defval" giá trị mặc định)
	public static Date getDate(String name, Date defval) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String date = getString(name, sdf.format(defval));
		try {
			return sdf.parse(date); // @return Giá trị tham số hoặc defval nếu tham số không tồn tại, parse Date trước khi @return
		} catch (Exception e) {
			return defval;
		}
	}

	/**
	 * Lưu file upload vào thư mục với tên duy nhất
	 * 
	 * @param name   tên tham số form
	 * @param folder thư mục chứa file
	 * @return File kết quả hoặc null nếu không upload
	 */
	public static File save(String name, String folder) {
//		File dir = new File(XHttp.getRealPath(folder));
		File dir = new File("folder"); 
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			Part part = RRSharer.request().getPart(name);
			if (part != null && part.getSize() > 0) {
				String fn = System.currentTimeMillis() + part.getSubmittedFileName();
					System.out.println("Filename part.getSubmittedFileName(): "+ fn);
				String filename = Integer.toHexString(fn.hashCode()) + fn.substring(fn.lastIndexOf("."));
					System.out.println("Filename Integer.toHexString(fn.hashCode()) + fn.substring(fn.lastIndexOf(\".\")): "+ fn);
				File file = new File(dir, filename);
				part.write(file.getAbsolutePath());
				return file;
			}
			return null; // @return null nếu không upload
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Đọc các giá trị tham số form vào các thuộc tính cùng tên của bean * @return Bean chứa dữ liệu form

//	public static <T> T getBean(Class<T> clazz) {
//		DateTimeConverter dtc = new DateConverter(new Date());
//		dtc.setPattern("MM/dd/yyyy");
//		ConvertUtils.register(dtc, Date.class);
//		try {
//			T bean = clazz.newInstance();
//			BeanUtils.populate(bean, RRSharer.request().getParameterMap());
//			return bean;
//
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
}
