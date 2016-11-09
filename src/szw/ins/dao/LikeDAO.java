package szw.ins.dao;

import java.util.List;

import szw.ins.model.Like;

public interface LikeDAO extends BaseDAO<Like>{
	public List<Like> find(String hql) ;
	
	public List<Like> find(String hql, Object[] params) ;
}
