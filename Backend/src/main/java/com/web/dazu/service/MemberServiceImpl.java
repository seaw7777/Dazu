package com.web.dazu.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.MemberMapper;
import com.web.dazu.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession session;

	@Override
	public Member selectMember(String id) throws Exception {
		return session.getMapper(MemberMapper.class).selectMember(id);
	}

	@Override
	public void insertMember(Member member) throws Exception {
		session.getMapper(MemberMapper.class).inserMember(member);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		session.getMapper(MemberMapper.class).updateMember(member);
	}

	@Override
	public void unlink(String accessToken) throws Exception {
		String reqURL = "https://kapi.kakao.com/v1/user/unlink";
		try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
	        
	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String result = "";
	        String line = "";
	        
	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        System.out.println(result);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteMember(String id) throws Exception {
		session.getMapper(MemberMapper.class).deleteMember(id);
	}

}
