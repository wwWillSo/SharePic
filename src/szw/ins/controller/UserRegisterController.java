package szw.ins.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import szw.ins.model.User;
import szw.ins.service.UserService;

@Controller
public class UserRegisterController {
	@Autowired
	private UserService userService ;
	@Autowired
	private User user ;
	
	@RequestMapping("/register_do")
	public String register() {
		return "/jsp/user/register" ;
	}
	
	@RequestMapping("/register")
	public String doRegister(@RequestParam(value = "portrait", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {
	        
		String id = request.getParameter("id") ;
		if (userService.get(User.class, id) == null) {
			String password = request.getParameter("password") ;
			String username = request.getParameter("username") ;
			String website = request.getParameter("website") ;
			String note = request.getParameter("note") ;
			String email = request.getParameter("email") ;
			String phone = request.getParameter("phone") ;
			String sex = request.getParameter("sex") ;
			String portrait = request.getSession().getServletContext().getRealPath("/") + id + "/" + file.getOriginalFilename();
			
			user.setUserid(id);
			user.setPassword(password);
			user.setUsername(username);
			user.setWebsite(website);
			user.setNote(note);
			user.setEmail(email);
			user.setPhone(phone);
			user.setSex(sex) ;
			
	        File targetFile = new File(portrait);

	        if(!targetFile.exists()){
				targetFile.mkdirs();
	        }

	        //±£´æ
	        try {
	            file.transferTo(targetFile);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        user.setPortrait(portrait);
	        
	        userService.save(user) ;
	        
	        return "/jsp/user/register_success" ;
		}
		
		return "/jsp/user/register" ;
		
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
}
