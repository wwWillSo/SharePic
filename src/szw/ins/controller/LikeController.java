package szw.ins.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import szw.ins.model.Like;
import szw.ins.model.Picture;
import szw.ins.model.User;
import szw.ins.service.LikeService;
import szw.ins.service.PictureService;
import szw.ins.service.UserService;

@Controller
public class LikeController {
	@Autowired
	private PictureService pictureService ;
	@Autowired
	private Like like ;
	@Autowired
	private LikeService likeService ;
	@Autowired
	private UserService userService ;
	
	@RequestMapping("/likePic")
	public String likeMyPic(HttpServletRequest request, ModelMap model) {
		int picid = Integer.parseInt(request.getParameter("picid")) ;
		Picture pic = pictureService.get(Picture.class, picid) ;
		User user = (User)request.getSession().getAttribute("user") ;
		user = userService.get(User.class, user.getUserid()) ;
		
		Iterator<Like> iter = likeService.findAll(Like.class).iterator() ;

		while (iter.hasNext()) {
			Like like_test = iter.next() ;
			if (like_test.getUser().getUserid().equals(user.getUserid()) && like_test.getPic().getPicid() == pic.getPicid()) {
				
				//此用户已经为此图片点过赞，只能是取消赞
				//user.getLike().remove(like_test) ;
				//pic.getLike().remove(like_test) ;
				
				likeService.delete(Like.class, like_test.getId());
				//return "/jsp/user/main" ;
				return "forward:showPicInfo.do?picid=" + picid ;
			}
		}
		
		//此用户未曾为此图片点过赞，那就添加赞
		like.setPic(pic);
		like.setUser(user);
		
		pic.getLike().add(like) ;

		user.getLike().add(like) ;
		
		likeService.save(like) ;
		//return "/jsp/user/main" ;
		return "forward:showPicInfo.do?picid=" + picid ;
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public Like getLike() {
		return like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

	public LikeService getLikeService() {
		return likeService;
	}

	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
