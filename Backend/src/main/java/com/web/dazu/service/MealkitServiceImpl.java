package com.web.dazu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.MealkitMapper;
import com.web.dazu.model.Mealkit;

@Service
public class MealkitServiceImpl implements MealkitService {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<Mealkit> selectAllMealkit(String dong) throws Exception {
		return session.getMapper(MealkitMapper.class).selectAllMealkit(dong);
	}

	@Override
	public void insertMealkit(Mealkit mealkit) throws Exception {
		session.getMapper(MealkitMapper.class).insertMealkit(mealkit);
		session.getMapper(MealkitMapper.class).insertclassinformationMealkit(mealkit);
	}

	@Override
	public void updateMealkit(Mealkit mealkit) throws Exception {
		session.getMapper(MealkitMapper.class).updateMealkit(mealkit);
	}

	@Override
	public void deleteMealkit(String code) throws Exception {
		session.getMapper(MealkitMapper.class).deleteMealkit(code);
	}

	@Override
	public Mealkit selectMealkit(String classcode) throws Exception {
		return session.getMapper(MealkitMapper.class).selectMealkit(classcode);
	}

}
