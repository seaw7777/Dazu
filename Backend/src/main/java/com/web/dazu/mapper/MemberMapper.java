package com.web.dazu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Member;
import com.web.dazu.model.Myclass;

@Mapper
public interface MemberMapper {

	Member selectMember(String id) throws Exception;

	void inserMember(Member member) throws Exception;

	void updateMember(Member member) throws Exception;

	void deleteMember(String id) throws Exception;

	List<Myclass> selectMyclass(String id) throws Exception;

	List<Myclass> selectCommingMyClass(String id) throws Exception;

}
