package com.web.dazu.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Member;

@Mapper
public interface MemberMapper {

	Member selectMember(String id) throws Exception;

	void insertMember(Member member) throws Exception;

	void updateMember(Member member) throws Exception;

	void deleteMember(String id) throws Exception;

}
