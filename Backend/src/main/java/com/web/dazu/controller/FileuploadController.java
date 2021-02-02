package com.web.dazu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.dazu.service.FileUploadService;

import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.util.HashMap;
import java.util.List; 

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/fileupload")
public class FileuploadController {
	@Autowired
	private FileUploadService fileuploadservice; 
	@ApiOperation(value = "파일 업로드 및 회원 정보 받아오기", response = String.class)
	@PostMapping
	public String uploadSingle(@RequestPart(value = "files", required = true) List<MultipartFile> file,
			@RequestParam("address") String address,@RequestParam("detailaddress") String detailaddress) throws Exception {
		System.out.println("진입");
		for (int i = 0; i < file.size(); i++) {
		    String rootPath = "home/Image";
		    System.out.println(rootPath);
		    String basePath = rootPath + "/" + "store";
		    System.out.println(basePath);
		    String filePath = basePath + "/" + file.get(i).getOriginalFilename();
		    System.out.println(filePath);
		    File dest = new File(filePath);
		    System.out.println("진입2");
		    fileuploadservice.fileup(filePath);
		    System.out.println("진입3");
		    file.get(i).transferTo(dest); // 파일 업로드 작업 수행
		}
	    return "uploaded";
	}
}

