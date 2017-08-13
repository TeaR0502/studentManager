package com.t.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t.dao.AskTypeDAO;
import com.t.entity.AskType;
import com.t.service.AskTypeService;

@Service
public class AskServiceimpl implements AskTypeService{
	@Autowired
	private AskTypeDAO askTypeDAO;

	@Override
	public List<AskType> queryAll() {
		
		return askTypeDAO.queryAllType();
	}

	@Override
	public AskType getType(String type) {
		// TODO Auto-generated method stub
		return askTypeDAO.getType(type);
	}
}
