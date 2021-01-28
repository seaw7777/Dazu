package com.web.dazu.service;

import com.web.dazu.model.Member;


public interface LoginService {

	String getAccessToken(String code) throws Exception;

	Member getMemberInfoKAKAO(String accessToken) throws Exception;

	void logout(String accessToken) throws Exception;
}
