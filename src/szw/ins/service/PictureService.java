package szw.ins.service;

import java.io.Serializable;
import java.util.List;

import szw.ins.model.Picture;
import szw.ins.model.User;

public interface PictureService {
	public Picture get(Class<Picture> entityClazz, Serializable id) ;
	
	public Serializable save(Picture entity) ;
	
	public void update(Picture entity) ;
	
	public void delete(Picture entity) ;
	
	public void delete(Class<Picture> entityClazz, Serializable id) ;
	
	public List<Picture> findAll(Class<Picture> entityClazz) ;
	
	public long findCount(Class<Picture> entityClazz) ;
	
	public List<Picture> find(String hql) ;
	
	public List<Picture> find(String hql, Object[] params) ;
	
	public List<Picture> findByPage(String hql, int pageNo, int pageSize) ;
	
	public List<Picture> findByPage(String hql, int pageNo, int pageSize, Object[] params) ;
	
	//∏˘æ›userid≤È’“Õº∆¨
	public List<Picture> findByUserid(User user) ;
	
}
