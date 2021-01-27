package com.web.dazu.mapper;

import com.web.dazu.model.Member;

public interface MemberMapper {

	Member selectMember(String id) throws Exception;

	void inserMember(Member member) throws Exception;

	void updateMember(Member member) throws Exception;

	void deleteMember(String id) throws Exception;

}
