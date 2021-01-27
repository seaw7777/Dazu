package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.Store;

public interface StoreService {

	List<Store> selectAllStore(String dong) throws Exception;

}
