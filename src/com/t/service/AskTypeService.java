package com.t.service;

import java.util.List;

import com.t.entity.AskType;

public interface AskTypeService {
	
	/**
	 * get a AskType object 
	 * @param type
	 * @return
	 */
	AskType getType(String type);
	
	/**
	 * 查询所有TYPE信息
	 * @return
	 */
	List<AskType> queryAll();
}
