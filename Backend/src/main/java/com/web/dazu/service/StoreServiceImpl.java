package com.web.dazu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.StoreMapper;
import com.web.dazu.model.Store;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Store> selectAllStore(String dong) throws Exception {
		return session.getMapper(StoreMapper.class).selectAllStore(dong);
	}

	@Override
	public void insertStore(Store store) throws Exception {
		session.getMapper(StoreMapper.class).insertStore(store);
	}

}
