package szw.ins.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {
	public T get(Class<T> entityClazz, Serializable id) ;
	
	public Serializable save(T entity) ;
	
	public void update(T entity) ;
	
	public void delete(T entity) ;
	
	public void delete(Class<T> entityClazz, Serializable id) ;
	
	public List<T> findAll(Class<T> entityClazz) ;
	
	public long findCount(Class<T> entityClazz) ;
}
