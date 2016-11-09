package szw.ins.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import szw.ins.model.Picture;
import szw.ins.model.User;
import szw.ins.service.PictureService;
import szw.ins.service.UserService;

@Controller
public class UserLoginController {
	@Autowired
	private UserService userService ;
	@Autowired
	private User user ;
	@Autowired
	private PictureService pictureService ;
	
	@RequestMapping("/userLogin")
	public String login(HttpServletRequest request, ModelMap model) {
		String id = request.getParameter("id") ;
		String password = request.getParameter("password") ;
		
		if (!"".equals(id) && !"".equals(password) && userService.get(User.class, id) != null && password.equals(userService.get(User.class, id).getPassword())) {
			
			user = userService.get(User.class, id) ;
			
			request.getSession().setAttribute("user", user);
			
			List<Picture> allPics = pictureService.findAll(Picture.class) ;
			request.getSession().setAttribute("allPics", allPics);
			
			List<Picture> myPics = pictureService.findByUserid(user) ;
			request.getSession().setAttribute("myPics", myPics);
			
			String all_or_my = request.getParameter("all_or_my") ;
			request.setAttribute("all_or_my", all_or_my);
			
			return "/jsp/user/main" ;
		} 
		
		return "/index" ;
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
}
