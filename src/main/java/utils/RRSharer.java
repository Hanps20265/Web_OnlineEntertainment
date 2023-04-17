package utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class RRSharer {
       
	private static Map<Long, HttpServletRequest> request = new HashMap<>();
		private static Map<Long, HttpServletResponse> response = new HashMap<>();
	public static void add (HttpServletRequest req, HttpServletResponse resp) {
		request.put(Thread.currentThread().getId(), req);
		response.put(Thread.currentThread().getId(), resp);
	}

	public static void remove() {
		request.remove(Thread.currentThread().getId(), request);
		response.remove(Thread.currentThread().getId(), response);
	}

	public static HttpServletRequest request() {
		return request.get(Thread.currentThread().getId());
	}

	public static HttpServletResponse response() {
		return response.get(Thread.currentThread().getId());
	}
}
