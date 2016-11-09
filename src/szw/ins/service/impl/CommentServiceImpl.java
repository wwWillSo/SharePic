package szw.ins.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import szw.ins.dao.CommentDAO;
import szw.ins.model.Comment;
import szw.ins.model.Picture;
import szw.ins.service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDAO commentDAO ;

	@Override
	public Comment get(Class<Comment> entityClazz, Serializable id) {
		return commentDAO.get(entityClazz, id) ;
	}

	@Override
	public Serializable save(Comment entity) {
		return commentDAO.save(entity) ;
	}

	@Override
	public void update(Comment entity) {
		commentDAO.update(entity);
	}

	@Override
	public void delete(Comment entity) {
		commentDAO.delete(entity);
	}

	@Override
	public void delete(Class<Comment> entityClazz, Serializable id) {
		commentDAO.delete(entityClazz, id);
	}

	@Override
	public List<Comment> findAll(Class<Comment> entityClazz) {
		return commentDAO.findAll(entityClazz) ;
	}

	@Override
	public long findCount(Class<Comment> entityClazz) {
		return commentDAO.findCount(entityClazz) ;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	//根据图片加载所有评论，并以{用户ID：字符串列表}map返回
	public List<Comment> getAllCommentByPicture(Picture picture) {
		Object[] params = {picture.getPicid()} ;
		List<Comment> allComments = commentDAO.find("from "+ Comment.class.getSimpleName() +" en where en.pic.picid = ?0", params) ;
		
		
		
		return allComments ;
	}
}
