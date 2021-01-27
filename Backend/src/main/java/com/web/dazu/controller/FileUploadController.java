package com.web.dazu.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile; 

import java.io.File; 

@RestController
@RequestMapping("/fileupload")
public class FileuploadController {
	@PostMapping
	public String uploadSingle(@RequestParam("files") MultipartFile file,
			@RequestParam("address") String address,@RequestParam("detailaddress") String detailaddress) throws Exception {
	    String rootPath = "C:\\Image";
	    String basePath = rootPath + "/" + "store";
	    String filePath = basePath + "/" + file.getOriginalFilename();
	    File dest = new File(filePath);
	    file.transferTo(dest); // 파일 업로드 작업 수행
	    return "uploaded";
	}
}

