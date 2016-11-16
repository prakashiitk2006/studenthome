package org.opola.apps.studenthome.dao;

public interface GenericDao<T> {
	long insert(T pObject);
	void update(T pObject);
	T findBy(long pObjectId);
	void delete(T pObject);
}
