package dao;

import java.util.List;

abstract class DAO<EntityType, KeyType> {
	abstract public EntityType create(EntityType u);
	abstract public EntityType update(EntityType u);
	abstract public EntityType remove(KeyType id);
	abstract public EntityType findById(KeyType id);
	abstract public List<EntityType> findPage(int page, int size);
	abstract public List<EntityType> findBySQL(KeyType jpql, Object... args);
	abstract public List<EntityType> findAll();
	abstract public List<EntityType> findKeyword(KeyType keyword);
//	abstract public EntityType findOne(Object... args);
//	abstract public List<EntityType> findByRole(boolean role);

}
