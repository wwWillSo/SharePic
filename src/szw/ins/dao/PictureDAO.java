package szw.ins.dao;

import java.util.List;

import szw.ins.model.Picture;

public interface PictureDAO extends BaseDAO<Picture>{
	public List<Picture> find(String hql) ;
	
	public List<Picture> find(String hql, Object[] params) ;
	
	public List<Picture> findByPage(String hql, int pageNo, int pageSize) ;
	
	public List<Picture> findByPage(String hql, int pageNo, int pageSize, Object[] params) ;
}
