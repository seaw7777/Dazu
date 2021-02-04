package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.Member;
import com.web.dazu.model.Myclass;

public interface MemberService {

	Member selectMember(String id) throws Exception;

	void insertMember(Member member) throws Exception;

	void updateMember(Member member) throws Exception;

	void unlink(String accessToken) throws Exception;

	void deleteMember(String id) throws Exception;

	List<Myclass> selectMyclass(String id) throws Exception;

	List<Myclass> selectCommingMyClass(String id) throws Exception;

}
