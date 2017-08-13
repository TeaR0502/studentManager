package com.t.service;

import com.t.entity.Users;

public interface UserService {
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return Users对象
	 */
	Users   queryUserByName(String username);
	/**
	 * 用户登录注册
	 * @param username
	 * @param password
	 * @return
	 */
	boolean UsersLogin(String username,String password);
	
}
