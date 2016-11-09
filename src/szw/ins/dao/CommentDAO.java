package szw.ins.dao;

import java.util.List;

import szw.ins.model.Comment;

public interface CommentDAO extends BaseDAO<Comment>{
	public List<Comment> find(String hql) ;
	
	public List<Comment> find(String hql, Object[] params) ;
}
