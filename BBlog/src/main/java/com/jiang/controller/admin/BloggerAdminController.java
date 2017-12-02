package com.jiang.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jiang.entity.Blogger;
import com.jiang.service.BloggerService;
import com.jiang.util.ResponseUtil;

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Autowired
	private BloggerService bloggerService;
	
	@RequestMapping("/update")
	public void update(@RequestParam("imageFile") MultipartFile imageFile, Blogger bgr, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean result = false;
		String msg;
		if(!imageFile.isEmpty()){
			String fileName = "blogger" + "." + imageFile.getOriginalFilename().split("\\.")[1];
			String imagePath = "/root/BBlog/image/avater/";
			bgr.setImagePath("/BBlog/image/avater/"+fileName);
			try {
				File file = new File(imagePath+fileName);
				if (!file.exists()) { // 如果路径不存在，创建 
					file.mkdirs();  
				} 
			imageFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
				msg = "更新异常";
			}
		}else {
			bgr.setImagePath(bloggerService.findById(1).getImagePath());
		}
		if(bloggerService.update(bgr)){
			result = true;
			msg = "更新成功";
		}else msg = "更新失败";
		if(result == true){
			response.sendRedirect("info");
		}else {
			JSONObject resultJson=new JSONObject();
			resultJson.put("result", result);
			resultJson.put("msg", msg);
			ResponseUtil.writeJson(response, resultJson);
		}
	}

	@RequestMapping("/info")
	public ModelAndView info() {
		ModelAndView mav = new ModelAndView("admin/index");
		mav.addObject("pagePath", "./admin/bloggerInfo.jsp");
		mav.addObject("blogger", bloggerService.findById(1));
		return mav;
	}
}
