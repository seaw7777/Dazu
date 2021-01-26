package com.web.dazu.service;

import java.util.HashMap;

public interface LoginService {

	String getAccessToken(String code);

	HashMap<String, Object> getUserInfo(String accessToken);

	void logout(String accessToken);

}
