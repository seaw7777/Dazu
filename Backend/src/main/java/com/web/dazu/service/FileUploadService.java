package com.web.dazu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public void fileup(List<MultipartFile> file,String index) throws Exception;
}	
