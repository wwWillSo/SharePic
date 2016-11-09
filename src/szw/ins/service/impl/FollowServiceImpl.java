package szw.ins.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import szw.ins.dao.FollowDAO;
import szw.ins.model.Follow;
import szw.ins.service.FollowService;

public class FollowServiceImpl implements FollowService{
	
	@Autowired
	private FollowDAO followDAO ;

	@Override
	public Follow get(Class<Follow> entityClazz, Serializable id) {
		return followDAO.get(entityClazz, id) ;
	}

	@Override
	public Serializable save(Follow entity) {
		return followDAO.save(entity) ;
	}

	@Override
	public void update(Follow entity) {
		followDAO.update(entity);
	}

	@Override
	public void delete(Follow entity) {
		followDAO.delete(entity);
	}

	@Override
	public void delete(Class<Follow> entityClazz, Serializable id) {
		followDAO.delete(entityClazz, id);
	}

	@Override
	public List<Follow> findAll(Class<Follow> entityClazz) {
		return followDAO.findAll(entityClazz) ;
	}

	@Override
	public long findCount(Class<Follow> entityClazz) {
		return followDAO.findCount(entityClazz) ;
	}

	public FollowDAO getFollowDAO() {
		return followDAO;
	}

	public void setFollowDAO(FollowDAO followDAO) {
		this.followDAO = followDAO;
	}

}
