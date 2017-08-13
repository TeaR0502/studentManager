package com.t.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.t.dao.UsersDAO;
import com.t.entity.Users;
import com.t.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public boolean UsersLogin(String username, String password) {
		System.out.println("进入loginservice");
		Users users = usersDAO.queryUsersByName(username);
		System.out.println(users);
		if (users != null && password.equals(users.getPassword())) {
		
				return true;
		
		}else {
			return false;
		}
		
	}

	@Override
	public Users queryUserByName(String username) {
		Users users = usersDAO.queryUsersByName(username);
		return users;
	}

}
