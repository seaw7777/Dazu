package com.web.dazu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Store;

@Mapper
public interface StoreMapper {

	List<Store> selectAllStore(String dong) throws Exception;

}
