package com.t.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.t.entity.LeaveApplication;

public interface LeaveApplicationDAO {
	
	
	
	/**
	 * create a new LeaveApplication Record
	 * @param leaveApplication
	 */
	void addLeaveApplication(LeaveApplication leaveApplication);

	/**
	 * query all LeaveApplication record 
	 * @return
	 */
	List<LeaveApplication> getStudentLeaveApplication(int stuId);
}
