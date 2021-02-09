package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.ClassReview;
import com.web.dazu.model.Store;

public interface StoreService {

	List<Store> selectAllStore(String dong) throws Exception;

	void insertStore(Store store) throws Exception;

	void updateStoreGrade(ClassReview review) throws Exception;

	Store selectStore(String usercode) throws Exception;

}
