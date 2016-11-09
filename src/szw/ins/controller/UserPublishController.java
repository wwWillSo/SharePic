package szw.ins.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import szw.ins.model.Picture;
import szw.ins.model.User;
import szw.ins.service.PictureService;

@Controller
public class UserPublishController {
	@Autowired
	private PictureService pictureService ;
	@Autowired
	private Picture picture ;
	
	@RequestMapping("/publish.do")
	public String publish () {
		return "/jsp/user/publish" ;
	}
	
	@RequestMapping("/publish")
	public String doPublish(@RequestParam(value = "picture", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user")  ;
		String path = request.getSession().getServletContext().getRealPath("/") + user.getUserid() + "/picture/" + file.getOriginalFilename();
		
		 File targetFile = new File(path);
		 if (!targetFile.exists()) {
			 targetFile.mkdirs() ;
		 }
		 
		//±£´æ
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        picture.setPicpath(user.getUserid() + "/picture/" + file.getOriginalFilename());
        picture.setPublishTime(new Date());
        picture.setUser(user);
        
        if (pictureService.save(picture) != null) {
        	pictureService.save(picture) ;
        	return "/jsp/user/publish_success" ;
        } else {
        	targetFile.delete() ;
        	return "/jsp/user/publish" ;
        }
        
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
}
