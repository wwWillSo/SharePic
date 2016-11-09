package szw.ins.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import szw.ins.model.Picture;
import szw.ins.service.PictureService;

@Controller
public class DeleteController {
	@Autowired
	private PictureService pictureService ;

	@RequestMapping("/deletePic")
	public String deleteMyPic(HttpServletRequest request, ModelMap model) {
		int picid = Integer.parseInt(request.getParameter("picid")) ;
		
		Picture picture = pictureService.get(Picture.class, picid) ;
		
		String path = request.getSession().getServletContext().getRealPath("/") +  picture.getPicpath();
		
		File targetFile = new File(path);
		
		try {
			targetFile.delete() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pictureService.delete(Picture.class, picid);
		
		return "forward:/jsp/user/main" ;
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
}
