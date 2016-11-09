package szw.ins.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import szw.ins.dao.UserDAO;
import szw.ins.model.User;
import szw.ins.service.UserService;
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO ;

	@Override
	public User get(Class<User> entityClazz, Serializable id) {
		return userDAO.get(entityClazz, id) ;
	}

	@Override
	public Serializable save(User entity) {
		return userDAO.save(entity) ;
	}

	@Override
	public void update(User entity) {
		userDAO.update(entity);
	}

	@Override
	public void delete(User entity) {
		userDAO.delete(entity);
	}

	@Override
	public void delete(Class<User> entityClazz, Serializable id) {
		userDAO.delete(entityClazz, id);
	}

	@Override
	public List<User> findAll(Class<User> entityClazz) {
		return userDAO.findAll(entityClazz) ;
	}

	@Override
	public long findCount(Class<User> entityClazz) {
		return userDAO.findCount(entityClazz) ;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
