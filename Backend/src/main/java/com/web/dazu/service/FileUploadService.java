package com.web.dazu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public void storefileup(List<MultipartFile> file,int index) throws Exception;
	public void classfileup(List<MultipartFile> file,int index) throws Exception;
	public void updateStoreDetail(String storecode, MultipartFile file) throws Exception;
	public void uploadmilkit(List<MultipartFile> file, int index) throws Exception;
}	
