package com.web.dazu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Mealkit;

@Mapper
public interface MealkitMapper {

	List<Mealkit> selectAllMealkit(String dong) throws Exception;

}
