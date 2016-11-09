package szw.ins.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import szw.ins.model.Comment;
import szw.ins.model.Picture;
import szw.ins.model.User;
import szw.ins.service.CommentService;
import szw.ins.service.PictureService;
import szw.ins.service.UserService;

@Controller
public class CommentController {
	@Autowired
	private PictureService pictureService ;
	@Autowired
	private UserService userService ;
	@Autowired
	private Comment comment ;
	@Autowired
	private CommentService commentService ;
	
	@RequestMapping("commentPic")
	public String commentMyPic(HttpServletRequest request, ModelMap model) {
		int picid = Integer.parseInt(request.getParameter("picid")) ;
		Picture pic = pictureService.get(Picture.class, picid) ;
		User user = (User)request.getSession().getAttribute("user") ;
		user = userService.get(User.class, user.getUserid()) ;
		
		String text = request.getParameter("text") ;
		
		comment.setPic(pic);
		comment.setUser(user);
		comment.setNote(text);
		
		pic.getComment().add(comment) ;

		user.getComment().add(comment) ;
		
		commentService.save(comment) ;
		
		return "forward:showPicInfo.do?picid=" + picid ;
	}



	public PictureService getPictureService() {
		return pictureService;
	}



	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}



	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	public Comment getComment() {
		return comment;
	}



	public void setComment(Comment comment) {
		this.comment = comment;
	}



	public CommentService getCommentService() {
		return commentService;
	}



	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
}
