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
	public void storefileup(List<MultipartFile> file, int index) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < file.size(); i++) {
			String rootPath = "/home/Image";
			String filePath = rootPath + "/" + Integer.toString(index) + "_" + "store" + "_" + "intro";
			File dest = new File(filePath);
			File sample = new File(rootPath);
			if (!sample.exists()) {
				try {
					sample.mkdir();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			file.get(i).transferTo(dest); // 파일 업로드 작업 수행
			sqlSession.getMapper(FileUploadMapper.class).fileupload(filePath);
		}
	}

	@Override
	public void classfileup(List<MultipartFile> file, int index) throws Exception {
		String[] str = new String[2];
		str[0] = "Thumbnail";
		str[1] = "intro";
		System.out.println("인덱스 확인 : "+index);
		for (int i = 0; i < file.size(); i++) {
			String rootPath = "/home/Image";
			String filePath = rootPath + "/" + Integer.toString(index) + "_" + "class" + "_" + str[i];
			File dest = new File(filePath);
			File sample = new File(rootPath);
			if (!sample.exists()) {
				try {
					sample.mkdir();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			file.get(i).transferTo(dest); // 파일 업로드 작업 수행
			sqlSession.getMapper(FileUploadMapper.class).fileupload(filePath);
		}

	}

	@Override
	public void updateStoreDetail(int storecode, MultipartFile file) throws Exception {
		String rootPath = "/home/Image";
		String filePath = rootPath + "/" + Integer.toString(storecode) + "_" + "class" + "_" + "intro";
		File dest = new File(filePath);
		File sample = new File(rootPath);
		if (!sample.exists()) {
			try {
				sample.mkdir();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		file.transferTo(dest); // 파일 업로드 작업 수행
		sqlSession.getMapper(FileUploadMapper.class).fileupload(filePath);
		
	}

	@Override
	public void uploadmilkit(List<MultipartFile> file, int index) throws Exception {
		// TODO Auto-generated method stub
		String[] str = new String[2];
		str[0] = "Thumbnail";
		str[1] = "intro";

		for (int i = 0; i < file.size(); i++) {
			String rootPath = "/home/Image";
			String filePath = rootPath + "/" + Integer.toString(index) + "_" + "milkit" + "_" + str[i];
			File dest = new File(filePath);
			File sample = new File(rootPath);
			if (!sample.exists()) {
				try {
					sample.mkdir();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			file.get(i).transferTo(dest); // 파일 업로드 작업 수행
			sqlSession.getMapper(FileUploadMapper.class).fileupload(filePath);
		}
	}

}
