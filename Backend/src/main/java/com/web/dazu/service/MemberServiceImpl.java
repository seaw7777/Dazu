package com.web.dazu.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dazu.mapper.MemberMapper;
import com.web.dazu.mapper.StoreMapper;
import com.web.dazu.model.Member;
import com.web.dazu.model.Myclass;

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
		String apiKey = "2ce9bedc0889520f06b58f54d0724e65";
	    String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
	    String jsonString = null;
	    
	    String addrutf = URLEncoder.encode(member.getAddress(), "UTF-8");

        String addr = apiUrl + "?query=" + addrutf;

        URL url = new URL(addr);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line = "";
        String result = "";

        while ((line = br.readLine()) != null) {
            result += line;
        }
        jsonString = result.toString();
		 
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> XYMap = new HashMap<String, String>();
		
		TypeReference<Map<String, Object>> typeRef 
        = new TypeReference<Map<String, Object>>(){};
	    Map<String, Object> jsonMap = mapper.readValue(jsonString, typeRef);
	
	    @SuppressWarnings("unchecked")
	    List<Map<String, String>> docList 
	        =  (List<Map<String, String>>) jsonMap.get("documents");	
	
	    Map<String, String> adList = (Map<String, String>) docList.get(0);
	    XYMap.put("x",adList.get("x"));
	    XYMap.put("y", adList.get("y"));

		member.setLat(XYMap.get("x"));
		member.setLng(XYMap.get("y"));
		    
		
		String dong = member.getDong();
		
		dong = dong.replaceAll(" ", "");
		
		member.setDong(dong);

		session.getMapper(MemberMapper.class).insertMember(member);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		String apiKey = "2ce9bedc0889520f06b58f54d0724e65";
	    String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
	    String jsonString = null;
	    
	    String addrutf = URLEncoder.encode(member.getAddress(), "UTF-8");

        String addr = apiUrl + "?query=" + addrutf;

        URL url = new URL(addr);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line = "";
        String result = "";

        while ((line = br.readLine()) != null) {
            result += line;
        }
        jsonString = result.toString();
		 
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> XYMap = new HashMap<String, String>();
		
		TypeReference<Map<String, Object>> typeRef 
        = new TypeReference<Map<String, Object>>(){};
	    Map<String, Object> jsonMap = mapper.readValue(jsonString, typeRef);
	
	    @SuppressWarnings("unchecked")
	    List<Map<String, String>> docList 
	        =  (List<Map<String, String>>) jsonMap.get("documents");	
	
	    Map<String, String> adList = (Map<String, String>) docList.get(0);
	    XYMap.put("x",adList.get("x"));
	    XYMap.put("y", adList.get("y"));

		member.setLat(XYMap.get("x"));
		member.setLng(XYMap.get("y"));
		    
		System.out.println(member.getLat() + member.getLng());
		
		String dong = member.getDong();
		System.out.println(member.getDong());
		
		dong = dong.replaceAll(" ", "");
		
		member.setDong(dong);
		System.out.println(member.getDong());
		
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
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String result = "";
	        String line = "";
	        
	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteMember(String id) throws Exception {
		session.getMapper(MemberMapper.class).deleteMember(id);
	}

	@Override
	public List<Myclass> selectMyclass(String id) throws Exception {
		return session.getMapper(MemberMapper.class).selectMyclass(id);
	}

	@Override
	public List<Myclass> selectCommingMyClass(String id) throws Exception {
		return session.getMapper(MemberMapper.class).selectCommingMyClass(id);
	}

}
