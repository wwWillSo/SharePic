package szw.ins.service;

import java.io.Serializable;
import java.util.List;

import szw.ins.model.Follow;

public interface FollowService {
	public Follow get(Class<Follow> entityClazz, Serializable id) ;
	
	public Serializable save(Follow entity) ;
	
	public void update(Follow entity) ;
	
	public void delete(Follow entity) ;
	
	public void delete(Class<Follow> entityClazz, Serializable id) ;
	
	public List<Follow> findAll(Class<Follow> entityClazz) ;
	
	public long findCount(Class<Follow> entityClazz) ;
}
