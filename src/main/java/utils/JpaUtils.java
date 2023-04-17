package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class JpaUtils {
	
	private static EntityManagerFactory factory;
	
	static public EntityManager getEntityManager() {
		if (factory==null || !factory.isOpen()) {
				factory = Persistence.createEntityManagerFactory("asm");
		}
		return factory.createEntityManager();
	}
	
	static public void shutdown() {
		if (factory!=null||factory.isOpen()) {
				factory.close();
		}
		factory =  null;
	}
	
	public static Query createMyQuery(String jpql, Object... args) {
		Query query = JpaUtils.getEntityManager().createQuery(jpql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query;
	}
}



//public static void main(String[] args) {
//	EntityManager em = JpaUtils.getEntityManager();
//	System.out.println(em);
//}