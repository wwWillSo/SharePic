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
	
	//����ͼƬ�����������ۣ�����{�û�ID���ַ����б�}map����
	public List<Comment> getAllCommentByPicture(Picture picture) ;
}
