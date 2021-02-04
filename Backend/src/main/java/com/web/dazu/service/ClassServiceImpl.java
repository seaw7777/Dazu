package com.web.dazu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.ClassMapper;
import com.web.dazu.mapper.StoreMapper;
import com.web.dazu.model.Class;
import com.web.dazu.model.ClassNotice;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassTime;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Class> selectAllClass(String dong) throws Exception {
		return session.getMapper(ClassMapper.class).selectAllClass(dong);
	}

	@Override
	public Class selectClass(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClass(classcode);
	}

	@Override
	public ClassTime selectClassTime(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassTime(classcode);
	}

	@Override
	public List<Class> selectClassByStore(String storecode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassByStore(storecode);
	}

	@Override
	public List<ClassReview> selectClassReview(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassReview(classcode);
	}

	@Override
	public List<ClassNotice> selectClassNotice(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassNotice(classcode);
	}

	@Override
	public void insertClassNotice(ClassNotice classNotice) throws Exception {
		session.getMapper(ClassMapper.class).insertClassNotice(classNotice);
	}

	@Override
	public void insertClassReview(ClassReview classreview) throws Exception {
		session.getMapper(ClassMapper.class).insertClassReview(classreview);
	}

	@Override
	public ClassNotice selectClassNoticeDetail(String class_notice_board_code) throws Exception {
		// TODO Auto-generated method stub
		return session.getMapper(ClassMapper.class).selectClassNoticeDetail(class_notice_board_code);
	}

}
