package com.web.dazu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.ClassReview;
import com.web.dazu.model.Store;

@Mapper
public interface StoreMapper {

	List<Store> selectAllStore(String dong) throws Exception;

	void insertStore(Store store) throws Exception;

	void updateStoreGrade(ClassReview review) throws Exception;

	Store selectStore(String usercode) throws Exception;

}
