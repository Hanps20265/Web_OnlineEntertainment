package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Shared;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtils;

public class ShareDAO extends DAO<Shared, String>{
	public EntityManager em;
	String findAll_JPQL = "SELECT e FROM Shared e";
	String findOne_JPQL = "SELECT e FROM Shared e WHERE e.video.videoId = ?1 AND e.user.userId = ?2";
	String findKeyword_JPQL = "SELECT DISTINCT e FROM Shared e WHERE e.video.title LIKE ?1";

	public ShareDAO() {
		em = JpaUtils.getEntityManager();
	};

	public Shared create(Shared entity) {
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

	public Shared update(Shared entity) {
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

	public Shared remove(String id) {
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			Shared entity = em.find(Shared.class, id);
			em.remove(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			return null;
		}
	}
	
	public Shared findById(String id) {
		Shared entity = em.find(Shared.class, id);
        return entity;
	}
	
	public Shared findOne(String videoId, String userId) {
		Object[] arr = {videoId, userId};
		List<Shared> list = this.findBySQL(findOne_JPQL, arr);
		if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Shared> findPage(int page, int size){
		Query query = JpaUtils.createMyQuery(findAll_JPQL);
		query.setFirstResult(page);
		query.setMaxResults(size);
		List<Shared> list = new ArrayList<Shared>();
		list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Shared> findBySQL(String jpql, Object... args) {
		try {
			Query query = JpaUtils.createMyQuery(jpql, args);
			
			List<Shared> resultList = (List<Shared>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Shared> findAll() {
		return this.findBySQL(findAll_JPQL);
	}
	
	public List<Shared> findKeyword(String keyword) {
		List<Shared> list = this.findBySQL(findKeyword_JPQL, keyword);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
}
