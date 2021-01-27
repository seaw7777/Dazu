package com.web.dazu.service;

import java.util.HashMap;


public interface LoginService {

	String getAccessToken(String code) throws Exception;

	HashMap<String, Object> getMemberInfoKAKAO(String accessToken) throws Exception;

	void logout(String accessToken) throws Exception;
}
