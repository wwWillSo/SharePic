package szw.ins.service;

import java.io.Serializable;
import java.util.List;

import szw.ins.model.Like;
import szw.ins.model.Picture;

public interface LikeService {
	public Like get(Class<Like> entityClazz, Serializable id) ;
	
	public Serializable save(Like entity) ;
	
	public void update(Like entity) ;
	
	public void delete(Like entity) ;
	
	public void delete(Class<Like> entityClazz, Serializable id) ;
	
	public List<Like> findAll(Class<Like> entityClazz) ;
	
	public long findCount(Class<Like> entityClazz) ;
	
	//����ͼƬ�������е���޵��û������ַ����б���
	public List<String> getAllLikeByPicture(Picture picture) ;
}
