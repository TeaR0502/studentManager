package com.t.dao;

import org.springframework.stereotype.Service;

import com.t.entity.LeaveApplication;

public interface LeaveApplicationDAO {
	
	/**
	 * create a new LeaveApplication Record
	 * @param leaveApplication
	 */
	void addLeaveApplication(LeaveApplication leaveApplication);
}
