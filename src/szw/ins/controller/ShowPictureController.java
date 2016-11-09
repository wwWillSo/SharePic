package szw.ins.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import szw.ins.model.Comment;
import szw.ins.model.Like;
import szw.ins.model.Picture;
import szw.ins.model.User;
import szw.ins.service.CommentService;
import szw.ins.service.LikeService;
import szw.ins.service.PictureService;

@Controller
public class ShowPictureController {
	
	@Autowired
	private PictureService pictureService ;
	@Autowired
	private LikeService likeService ;
	@Autowired
	private CommentService commentService ;
	
	private User user ;
	
	@RequestMapping("/showAllPic.do")
	public String showAllPic(HttpServletRequest request, ModelMap model) {
		List<Picture> allPics = pictureService.findAll(Picture.class) ;
		request.getSession().setAttribute("allPics", allPics);

		return "jsp/user/showAllPic" ;
	}
	
	@RequestMapping("/showMyPic.do")
	public String showMyPic(HttpServletRequest request, ModelMap model) {
		user = (User) request.getSession().getAttribute("user") ;
		
		List<Picture> myPics = pictureService.findByUserid(user) ;
		
		request.getSession().setAttribute("myPics", myPics);
		
		return "jsp/user/showMyPic" ;
	}
	
	@RequestMapping("/showPicInfo.do")
	public String showPicInfo(HttpServletRequest request, ModelMap model) {
		user = (User) request.getSession().getAttribute("user") ;
		
		int picid = Integer.parseInt(request.getParameter("picid")) ;
		
		Picture picture = pictureService.get(Picture.class, picid) ;
		
		//取得图片所有赞
		List<String> allLikes = likeService.getAllLikeByPicture(picture) ;
		//取得图片所有评论
		List<Comment> allComments = commentService.getAllCommentByPicture(picture) ;
		
		if (picture.getUser().getUserid().equals(user.getUserid())) {			//自己的图片
			request.setAttribute("selectedPic", picture);
			request.setAttribute("delete_flag", "true");
			
			//此用户并未为此图片点赞，心形按钮不变红
			request.setAttribute("like_red", "false");
			
			Iterator<Like> iter = picture.getLike().iterator() ;
			while (iter.hasNext()) {
				Like like_test = iter.next() ;
				if (like_test.getUser().getUserid().equals(user.getUserid()) &&
						like_test.getPic().getPicid() == picid) {
					//此用户已为此图片点赞，心形按钮变红
					request.setAttribute("like_red", "true");
				}
			}
			
			request.setAttribute("allLikes", allLikes);
			request.setAttribute("allComments", allComments);
			
			return "jsp/user/showPicInfo" ;
		} else {		//其他人的图片
			request.setAttribute("selectedPic", picture);
			request.setAttribute("delete_flag", "false");
			
			//此用户并未为此图片点赞，心形按钮不变红
			request.setAttribute("like_red", "false");
			
			Iterator<Like> iter = picture.getLike().iterator() ;
			while (iter.hasNext()) {
				Like like_test = iter.next() ;
				if (like_test.getUser().getUserid().equals(user.getUserid()) &&
						like_test.getPic().getPicid() == picid) {
					//此用户已为此图片点赞，心形按钮变红
					request.setAttribute("like_red", "true");
				}
			}
			
			request.setAttribute("allLikes", allLikes);
			request.setAttribute("allComments", allComments);
			
			return "jsp/user/showPicInfo" ;
		}
	}


	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LikeService getLikeService() {
		return likeService;
	}

	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
}
