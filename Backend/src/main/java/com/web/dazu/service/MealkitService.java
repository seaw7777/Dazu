package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.Mealkit;

public interface MealkitService {

	List<Mealkit> selectAllMealkit(String dong) throws Exception;

	void insertMealkit(Mealkit mealkit) throws Exception;

	void updateMealkit(Mealkit mealkit) throws Exception;

	void deleteMealkit(String code) throws Exception;

	Mealkit selectMealkit(String classcode) throws Exception;

}
