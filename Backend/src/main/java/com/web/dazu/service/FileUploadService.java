package com.web.dazu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public void storefileup(List<MultipartFile> file,int index) throws Exception;
	public void classfileup(List<MultipartFile> file,String index) throws Exception;
	public void updateStoreDetail(int storecode, MultipartFile file) throws Exception;
}	
