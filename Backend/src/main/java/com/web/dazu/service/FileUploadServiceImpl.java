package com.web.dazu.service;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.dazu.mapper.FileUploadMapper;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void fileup(List<MultipartFile> file, String index) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < file.size(); i++) {
			String rootPath = "home/Image/";
			String basePath = rootPath + "/" ;
			String filePath = basePath + "/" + index + "-" + file.get(i).getOriginalFilename();
			File dest = new File(filePath);
			file.get(i).transferTo(dest); // 파일 업로드 작업 수행
			sqlSession.getMapper(FileUploadMapper.class).fileupload(filePath);
		}
	}
}
