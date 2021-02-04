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
import com.web.dazu.model.ClassRoom;
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
	public void insertClassNotice(ClassReview review) throws Exception {
		session.getMapper(ClassMapper.class).insertClassNotice(review);
	}

	@Override
	public void insertClassRoom(ClassRoom room) throws Exception {
		session.getMapper(ClassMapper.class).insertClassRoom(room);
	}

}
