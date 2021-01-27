package com.web.dazu.service;

import com.web.dazu.model.Member;

public interface MemberService {

	Member selectMember(String id) throws Exception;

	void insertMember(Member member) throws Exception;

	void updateMember(Member member) throws Exception;

	void unlink(String accessToken) throws Exception;

	void deleteMember(String id) throws Exception;

}
