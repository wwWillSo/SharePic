package szw.ins.service;

import java.io.Serializable;
import java.util.List;

import szw.ins.model.Comment;
import szw.ins.model.Picture;

public interface CommentService {
	public Comment get(Class<Comment> entityClazz, Serializable id) ;
	
	public Serializable save(Comment entity) ;
	
	public void update(Comment entity) ;
	
	public void delete(Comment entity) ;
	
	public void delete(Class<Comment> entityClazz, Serializable id) ;
	
	public List<Comment> findAll(Class<Comment> entityClazz) ;
	
	public long findCount(Class<Comment> entityClazz) ;
	
	//根据图片加载所有评论，并以{用户ID：字符串列表}map返回
	public List<Comment> getAllCommentByPicture(Picture picture) ;
}
