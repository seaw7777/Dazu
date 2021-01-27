package com.web.dazu.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Member;

@Mapper
public interface LoginMapper {

	Member getUserInfo(String id) throws Exception;

}
