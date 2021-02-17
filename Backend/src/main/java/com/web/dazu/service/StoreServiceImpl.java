package com.web.dazu.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.web.dazu.mapper.StoreMapper;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.Store;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private FileUploadService fileuploadservice;
	@Autowired
	private SqlSession session;

	@Override
	public List<Store> selectAllStore(String dong) throws Exception {
		return session.getMapper(StoreMapper.class).selectAllStore(dong);
	}

	@Override
	public void insertStore(List<MultipartFile> file,Store store) throws Exception {
		
		String apiKey = "2ce9bedc0889520f06b58f54d0724e65";
	    String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
	    String jsonString = null;
	    String addrutf = URLEncoder.encode(store.getStore_location(), "UTF-8");

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

		store.setLat(XYMap.get("x"));
		store.setLng(XYMap.get("y"));

		String dong = store.getDong();
		
		dong = dong.replaceAll(" ", "");
		
		store.setDong(dong);

	    session.getMapper(StoreMapper.class).insertStore(store);
	    fileuploadservice.storefileup(file, session.getMapper(StoreMapper.class).getstorecode(store));
	}

	@Override
	public void updateStoreGrade(ClassReview review) throws Exception {
		session.getMapper(StoreMapper.class).updateStoreGrade(review);
	}

	@Override
	public Store selectStore(String usercode) throws Exception {
		return session.getMapper(StoreMapper.class).selectStore(usercode);
	}

	@Override
	public void updateStoreName(Store name) throws Exception {
		session.getMapper(StoreMapper.class).updateStoreName(name);
	}

	@Override
	public void updateStoreAddress(Store store) throws Exception {
		String apiKey = "2ce9bedc0889520f06b58f54d0724e65";
	    String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
	    String jsonString = null;
	    String addrutf = URLEncoder.encode(store.getStore_location(), "UTF-8");

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

		store.setLat(XYMap.get("x"));
		store.setLng(XYMap.get("y"));

		
		session.getMapper(StoreMapper.class).updateStoreAddress(store);
	}

}
