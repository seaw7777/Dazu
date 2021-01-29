package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.Class;

public interface ClassService {

	List<Class> selectAllClass(String dong) throws Exception;

}
