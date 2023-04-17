package dao;

import entity.Users;
import utils.JpaUtils;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


public class UserDAO extends DAO<Users, String>{
	public EntityManager em;
	
	String findAll_JPQL = "SELECT e FROM Users e";
	String findKeyword_JPQL = "SELECT e FROM Users e WHERE e.fullname LIKE ?1";
	String findOne_JPQL = "SELECT e FROM Users e WHERE e.userId = ?1 AND e.password =? 2";
	String findByRole_JPQL = "SELECT e FROM Users e WHERE e.admin = ?1";
	String findUsersByVideoId_JPQL = "SELECT e.user FROM Favorites e WHERE e.video.videoId = ?1";
	String findUserByEmail = "SELECT e FROM Users e WHERE e.email LIKE ?1";
	
	public UserDAO() {
		em = JpaUtils.getEntityManager();
	};

	public Users create(Users entity) {
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

	public Users update(Users entity) {
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

	public Users remove(String id) {
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			Users entity = em.find(Users.class, id);
			em.remove(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			return null;
		}
	}
	
	public Users findById(String id) {
		Users entity = em.find(Users.class, id);
        return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<Users> findPage(int page, int size){
		Query query = JpaUtils.createMyQuery(findAll_JPQL);
		query.setFirstResult(page);
		query.setMaxResults(size);
		List<Users> list = new ArrayList<Users>();
		list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Users> findBySQL(String jpql, Object... args) {
		try {
			Query query = JpaUtils.createMyQuery(jpql, args);
			
			List<Users> resultList = (List<Users>) query.getResultList();
			return resultList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Users> findAll() {
		return this.findBySQL(findAll_JPQL);
	}
	
	public List<Users> findKeyword(String keyword) {
		keyword = "%"+keyword+"%";
		List<Users> list = this.findBySQL(findKeyword_JPQL, keyword);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}

	public Users findUserByEmail(String email) {
		
		List<Users> list = this.findBySQL(findKeyword_JPQL, email);
		if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
	} 
	
	public Users findOne(Object...args) {
		List<Users> list = this.findBySQL(findOne_JPQL, args);
		if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
	}

	public List<Users> findByRole(boolean role) {
		List<Users> list = this.findBySQL(findByRole_JPQL, role);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
	
	public List<Users> findUsersByVideoId(String videoId) {
		List<Users> list = this.findBySQL(findUsersByVideoId_JPQL, videoId);
		if (list.isEmpty()) {
            return null;
        }
        return list;
	}
	
}
