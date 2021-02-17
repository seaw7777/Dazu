package com.web.dazu.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.web.dazu.mapper.MemberMapper;
import com.web.dazu.model.Member;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private SqlSession session;

	@Override
	public String getAccessToken(String code) throws Exception{
		String accessToken = "";
        String refreshToken = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        
        URL url = new URL(reqURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        
        //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=authorization_code");
//      sb.append("&client_id=2ce9bedc0889520f06b58f54d0724e65");
        sb.append("&redirect_uri=https://i4d104.p.ssafy.io/user");

//      sb.append("&redirect_uri=http://localhost:8080/user");

        sb.append("&code=" + code);
        bw.write(sb.toString());
        bw.flush();
        
        //    결과 코드가 200이라면 성공
        int responseCode = conn.getResponseCode();

        //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        String result = "";
        
        while ((line = br.readLine()) != null) {
            result += line;
        }
        
        // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(result);
        
        accessToken = element.getAsJsonObject().get("access_token").getAsString();
        refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
        
        
        br.close();
        bw.close();
        
        return accessToken;
	}

	@Override
	public Member getMemberInfoKAKAO(String accessToken) throws Exception{
		//	    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		URL url = new URL(reqURL);
	     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	     conn.setRequestMethod("POST");
	        
	     //    요청에 필요한 Header에 포함될 내용
	     conn.setRequestProperty("Authorization", "Bearer " + accessToken);
	        
	     int responseCode = conn.getResponseCode();
	        
	     BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	     String line = "";
	     String result = "";
	        
	     while ((line = br.readLine()) != null) {
	         result += line;
	     }
	        
	     JsonParser parser = new JsonParser();
	     JsonElement element = parser.parse(result);
	        
	     JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	     String id = element.getAsJsonObject().get("id").getAsString();
	        
	     String nickname = properties.getAsJsonObject().get("nickname").getAsString();
	     String profileImage = properties.getAsJsonObject().get("profile_image").getAsString();
	     
	     System.out.println(nickname + " " + id + " " + accessToken +  " " + profileImage);
	     
	     Member member1 = selectMember(id);
	     
	     Member member = new Member();
	     
	     if(member1 != null) {
	    	 member.setAddress(member1.getAddress());
		     member.setAddress_detail(member1.getAddress_detail());
		     member.setCreate_date(member1.getCreate_date());
		     member.setDong(member1.getDong());
		     member.setLat(member1.getLat());
		     member.setLng(member1.getLng());
		     member.setUsertype(member1.getUsertype());
	     }

	     member.setNickname(nickname);
	     member.setProfileImage(profileImage);
	     member.setUsercode(id);
	     member.setAccessToken(accessToken);
	     
		    
		 return member;
	}

	private Member selectMember(String id) throws Exception{
		return session.getMapper(MemberMapper.class).selectMember(id);
	}

	@Override
	public void logout(String accessToken) throws Exception{
		String reqURL = "https://kapi.kakao.com/v1/user/logout";
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
	}

}
