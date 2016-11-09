package szw.ins.service;

import java.io.Serializable;
import java.util.List;

import szw.ins.model.User;

public interface UserService {
	public User get(Class<User> entityClazz, Serializable id) ;
	
	public Serializable save(User entity) ;
	
	public void update(User entity) ;
	
	public void delete(User entity) ;
	
	public void delete(Class<User> entityClazz, Serializable id) ;
	
	public List<User> findAll(Class<User> entityClazz) ;
	
	public long findCount(Class<User> entityClazz) ;
}
