package com.t.dao;

import java.util.List;

import com.t.entity.AskType;

public interface AskTypeDAO {
	/**
	 * get a AskType object 
	 * @param type
	 * @return
	 */
	AskType getType(String type);
	
	/**
	 * get all Type
	 * 
	 * @return a list of AskType object
	 */
	List<AskType> queryAllType();
	
	/**
	 * 添加请假缘由
	 * @param askType
	 */
	void addType(AskType askType);
}
