package dao;

import java.util.ArrayList;
import java.util.List;
import entity.Videos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtils;

public class VideoDAO extends DAO<Videos, String>{

	public EntityManager em;
	String findAll_JPQL = "SELECT e FROM Videos e ORDER BY e.views desc";
	String findKeyword_JPQL = "SELECT DISTINCT e.video FROM Favorites e WHERE e.video.title LIKE ?1";
	String findByActive_JPQL = "SELECT e FROM Videos e WHERE e.active = ?1";
	String findVideosFavorited_JPQL = "SELECT e FROM Videos e WHERE e.favorites IS NOT EMPTY"; 
	String findVideosNOTFavorited_JPQL = "SELECT e FROM Videos e WHERE e.favorites IS EMPTY"; 
	String findVideosTheMostFavorited_JPQL = "SELECT o.video FROM Favorites o GROUP BY o.video.videoId ORDER BY count(o.video)";
	String findVideosFavoritedByUserID_JPQL = "SELECT DISTINCT e.video FROM Favorites e WHERE e.user.userId = ?1";
	
	public VideoDAO() {
		em = JpaUtils.getEntityManager();
	};

	public Videos create(Videos entity) {
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			em.persist(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			return null;
		}
	}

	public Videos update(Videos entity) {
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			em.merge(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			return null;
		}
	}

	public Videos remove(String id) {
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			Videos entity = em.find(Videos.class, id);
			em.remove(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			return null;
		}
	}
	
	public Videos findById(String id) {
		Videos entity = em.find(Videos.class, id);
        return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> findPage(int page, int size){
		Query query = JpaUtils.createMyQuery(findAll_JPQL);
		query.setFirstResult(page);
		query.setMaxResults(size);
		List<Videos> list = new ArrayList<Videos>();
		list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> findBySQL(String jpql, Object... args) {
		try {
			Query query = JpaUtils.createMyQuery(jpql, args);
			
			List<Videos> resultList = (List<Videos>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Videos> findAll() {
		return this.findBySQL(findAll_JPQL);
	}
	
	public List<Videos> findKeyword(String keyword) {
		keyword = "%"+keyword+"%";
		List<Videos> list = this.findBySQL(findKeyword_JPQL, keyword);
		if (list.isEmpty()) {
            return null;
        }
        return list;
        
	}
	
	public List<Videos> findByActive(boolean active) {
		List<Videos> list = this.findBySQL(findByActive_JPQL, active);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}

	public List<Videos> findVideosFavorited(boolean favorite) {
		List<Videos> list = new ArrayList<Videos>();
		if(favorite) {
			list = this.findBySQL(findVideosFavorited_JPQL);
		} else {
			list = this.findBySQL(findVideosNOTFavorited_JPQL);
		}
		
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
	
	public List<Videos> findVideosTheMostFavorited() {
		List<Videos> list = this.findBySQL(findVideosTheMostFavorited_JPQL);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
	
	public List<Videos> findVideosFavoritedByUserID(String userId) {
		List<Videos> list = this.findBySQL(findVideosFavoritedByUserID_JPQL, userId);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
}
