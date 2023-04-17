package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Favorites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtils;

public class FavoriteDAO extends DAO<Favorites, String>{

	public EntityManager em;
	String findAll_JPQL = "SELECT e FROM Favorites e";
	String findOne_JPQL = "SELECT e FROM Favorites e WHERE e.video.videoId = ?1 AND e.user.userId = ?2";
	String findKeyword_JPQL = "SELECT DISTINCT e FROM Favorites e WHERE e.video.title LIKE ?1";
	String findFavoritesByUserID_JPQL = "SELECT DISTINCT e FROM Favorites e WHERE e.user.userId = ?1";
	String years_JPQL = "SELECT DISTINCT year(e.likeDate) FROM Favorites e Order By year(e.likeDate) desc";

	public FavoriteDAO() {
		em = JpaUtils.getEntityManager();
	};

	public Favorites create(Favorites entity) {
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

	public Favorites update(Favorites entity) {
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

	public Favorites remove(String id) {
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			Favorites entity = em.find(Favorites.class, id);
			em.remove(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			return null;
		}
	}
	
	public Favorites findById(String id) {
		Favorites entity = em.find(Favorites.class, id);
        return entity;
	}
	
	public Favorites findOne(String videoId, String userId) {
		Object[] arr = {videoId, userId};
		List<Favorites> list = this.findBySQL(findOne_JPQL, arr);
		if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Favorites> findPage(int page, int size){
		Query query = JpaUtils.createMyQuery(findAll_JPQL);
		query.setFirstResult(page);
		query.setMaxResults(size);
		List<Favorites> list = new ArrayList<Favorites>();
		list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Favorites> findBySQL(String jpql, Object... args) {
		try {
			Query query = JpaUtils.createMyQuery(jpql, args);
			
			List<Favorites> resultList = (List<Favorites>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Favorites> findAll() {
		return this.findBySQL(findAll_JPQL);
	}
	
	public List<Favorites> findKeyword(String keyword) {
		List<Favorites> list = this.findBySQL(findKeyword_JPQL, keyword);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> selectYears() {
		try {
			Query query = JpaUtils.createMyQuery(years_JPQL);
			List<Integer> resultList = (List<Integer>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
		
	public List<Favorites> findFavoritesByUserID(String userId) {
		List<Favorites> list = this.findBySQL(findFavoritesByUserID_JPQL, userId);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}

	
}
