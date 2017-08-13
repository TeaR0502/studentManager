package com.t.dao;

import com.t.entity.Users;

public interface UsersDAO {
	
	/**
	 * 通过用户名查询用户信息
	 * @param username
	 * @return
	 */
	Users queryUsersByName(String username);
	
	/**
	 * 添加学生
	 * @param student
	 */
	void addStudent(Users student) ;
	/**
	 * 添加老师
	 * @param user
	 */
	void addTeacher(Users user) ;
	
}
