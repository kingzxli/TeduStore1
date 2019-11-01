package cn.tedu.store.controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class uploadController {
	
	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	
	@RequestMapping("/uploadFile.do")
	public String uploadFile(MultipartFile file) throws Exception{
		file.transferTo(new File("/home/soft01/0lzx",file.getOriginalFilename()));
		return "redirect:../main/showIndex.do";
	}

}
