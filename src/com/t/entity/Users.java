package com.t.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_ID_seq")
	@SequenceGenerator(name = "User_ID_seq", sequenceName = "User_ID_seq", allocationSize = 1, initialValue = 51)
	private int id;
	private String username;
	private String password;
	private String realname;
	private String job;
	@ManyToOne
	private Users teacher;
	@OneToMany(targetEntity=LeaveApplication.class)
	private List<LeaveApplication> list = new LinkedList<>();

	public List<LeaveApplication> getList() {
		return list;
	}

	public void setList(List<LeaveApplication> list) {
		this.list = list;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Users getTeacher() {
		return teacher;
	}

	public void setTeacher(Users teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", job=" + job + ", teacher=" + teacher + ", list=" + list + "]";
	}

}
