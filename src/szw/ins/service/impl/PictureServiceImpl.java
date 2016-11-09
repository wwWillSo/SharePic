package szw.ins.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import szw.ins.dao.PictureDAO;
import szw.ins.model.Picture;
import szw.ins.model.User;
import szw.ins.service.PictureService;
@Transactional
public class PictureServiceImpl implements PictureService{
	
	@Autowired
	private PictureDAO pictureDAO ;
	
	@Override
	public Picture get(Class<Picture> entityClazz, Serializable id) {
		return pictureDAO.get(entityClazz, id) ;
	}

	@Override
	public Serializable save(Picture entity) {
		return pictureDAO.save(entity) ;
	}

	@Override
	public void update(Picture entity) {
		pictureDAO.update(entity);
	}

	@Override
	public void delete(Picture entity) {
		pictureDAO.delete(entity);
	}

	@Override
	public void delete(Class<Picture> entityClazz, Serializable id) {
		pictureDAO.delete(entityClazz, id);
	}

	@Override
	public List<Picture> findAll(Class<Picture> entityClazz) {
		return pictureDAO.findAll(entityClazz) ;
	}

	@Override
	public long findCount(Class<Picture> entityClazz) {
		return pictureDAO.findCount(entityClazz) ;
	}

	public PictureDAO getPictureDAO() {
		return pictureDAO;
	}

	public void setPictureDAO(PictureDAO pictureDAO) {
		this.pictureDAO = pictureDAO;
	}
	
	public List<Picture> find(String hql)  {
		return pictureDAO.find(hql) ;
	}
	
	public List<Picture> find(String hql, Object[] params) {
		return pictureDAO.find(hql, params) ;
	}
	
	public List<Picture> findByPage(String hql, int pageNo, int pageSize) {
		return pictureDAO.findByPage(hql, pageNo, pageSize) ;
	}
	
	public List<Picture> findByPage(String hql, int pageNo, int pageSize, Object[] params) {
		return pictureDAO.findByPage(hql, pageNo, pageSize, params) ;
	}
	
	//∏˘æ›userid≤È’“Õº∆¨
	public List<Picture> findByUserid(User user) {
		String[] params = {user.getUserid()} ;
		return pictureDAO.find("from "+ Picture.class.getSimpleName() +" en where en.user.userid = ?0", params) ;
	}
}
