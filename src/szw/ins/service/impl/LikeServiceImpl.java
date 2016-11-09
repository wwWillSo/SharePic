package szw.ins.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import szw.ins.dao.LikeDAO;
import szw.ins.model.Like;
import szw.ins.model.Picture;
import szw.ins.service.LikeService;

public class LikeServiceImpl implements LikeService{
	
	@Autowired
	private LikeDAO likeDAO ;

	@Override
	public Like get(Class<Like> entityClazz, Serializable id) {
		return likeDAO.get(entityClazz, id) ;
	}

	@Override
	public Serializable save(Like entity) {
		return likeDAO.save(entity) ;
	}

	@Override
	public void update(Like entity) {
		likeDAO.update(entity);
	}

	@Override
	public void delete(Like entity) {
		likeDAO.delete(entity);
	}

	@Override
	public void delete(Class<Like> entityClazz, Serializable id) {
		likeDAO.delete(entityClazz, id);
	}

	@Override
	public List<Like> findAll(Class<Like> entityClazz) {
		return likeDAO.findAll(entityClazz) ;
	}

	@Override
	public long findCount(Class<Like> entityClazz) {
		return likeDAO.findCount(entityClazz) ;
	}

	public LikeDAO getLikeDAO() {
		return likeDAO;
	}

	public void setLikeDAO(LikeDAO likeDAO) {
		this.likeDAO = likeDAO;
	}
	
	//根据图片加载所有点过赞的用户，以字符串列表返回
	public List<String> getAllLikeByPicture(Picture picture) {
		Object[] params = {picture.getPicid()} ;
		List<Like> allLikesOfPicture = likeDAO.find("from "+ Like.class.getSimpleName() +" en where en.pic.picid = ?0", params) ;
		Iterator<Like> iter = allLikesOfPicture.iterator() ;
		
		List<String> allLikes = new ArrayList<String>() ;
		
		while (iter.hasNext()) {
			Like like = iter.next() ;
			String userid = like.getUser().getUserid() ;
			allLikes.add(userid) ;
		}
		
		return allLikes ;
	}

}
