package com.web.dazu.service;

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
	public int fileup(String filePath) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(FileUploadMapper.class).fileupload(filePath);
	}
	


}
