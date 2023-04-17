package dao;

import java.util.List;

import entity.Report;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtils;

public class ReportDAO {
	public EntityManager em;
	
	String report_JPQL = "SELECT new Report(e.video.title, count(e), max(e.likeDate), min(e.likeDate)) "
						+ "	FROM Favorites e"
						+ " GROUP BY e.video.title";
	 
	public ReportDAO() {
		em = JpaUtils.getEntityManager();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Report> findBySQL(String jpql, Object... args) {
		try {
			Query query = JpaUtils.createMyQuery(jpql, args);
			
			List<Report> resultList = (List<Report>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public List<Report> report_JPQL() {
		List<Report> list = this.findBySQL(report_JPQL);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
	
	public static void main(String[] args) {
		ReportDAO report = new ReportDAO();
		List<Report> listR = report.report_JPQL();
		for(Report r: listR) {
			System.out.println(r.getGroup()+" - " + r.getLikes() + "  - "+r.getOldest()+" - " + r.getNewest());
		}
//		
//		EntityManager em = JpaUtils.getEntityManager();
//		String jpql = "select new Report(o.video.title, count(o), min(o.likeDate), max(o.likeDate)) from Favorites o group by o.video.title";
//		TypedQuery<Report> qr= em.createQuery(jpql, Report.class);
//		List<Report> reportlist = qr.getResultList();
//		
//		for (Report r : reportlist) {
//			System.out.println(r.getGroup()+" - " + r.getLikes() + "  - "+r.getOldest()+" - " + r.getNewest());
//		}
		
	}
	
	String findUsersFavoritedByVideoTitle_JPQL = "SELECT e.user.userId, e.user.fullname, e.user.email, e.likeDate FROM Favorites e WHERE e.video.title = ?1";

	@SuppressWarnings("unchecked")
	public List<Object[]> findUsersFavoritedByVideoTitle(String title) {
        try {
			Query query = JpaUtils.createMyQuery(findUsersFavoritedByVideoTitle_JPQL, title);
			
			List<Object[]> resultList = (List<Object[]>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	String findUsersFavorited_JPQL = "SELECT e.user.userId, e.user.fullname, e.user.email, e.likeDate FROM Favorites e";

	@SuppressWarnings("unchecked")
	public List<Object[]> findUsersFavorited() {
        try {
			Query query = JpaUtils.createMyQuery(findUsersFavorited_JPQL);
			
			List<Object[]> resultList = (List<Object[]>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	String findUsersSharedByVideoTitle_JPQL = "SELECT  e.user.userId, e.user.fullname, e.user.email, e.shareDate FROM Shared e WHERE e.video.title = ?1";

	@SuppressWarnings("unchecked")
	public List<Object[]> findUsersSharedByVideoTitle(String title) {
        try {
			Query query = JpaUtils.createMyQuery(findUsersSharedByVideoTitle_JPQL, title);
			
			List<Object[]> resultList = (List<Object[]>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	String findUsersShared_JPQL = "SELECT  e.user.userId, e.user.fullname, e.user.email, e.shareDate FROM Shared e ";
	@SuppressWarnings("unchecked")
	public List<Object[]> findUsersShared() {
        try {
			Query query = JpaUtils.createMyQuery(findUsersShared_JPQL);
			
			List<Object[]> resultList = (List<Object[]>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
