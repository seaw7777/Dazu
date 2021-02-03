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
	public List<Mealkit> selectAllMealkit() throws Exception {
		return session.getMapper(MealkitMapper.class).selectAllMealkit();
	}

}
