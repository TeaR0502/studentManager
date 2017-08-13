package com.t.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.t.entity.LeaveApplication;

public interface LeaveApplicationDAO {
	
	/**
	 * update a LeaveApplication
	 * @param status
	 * @param idf
	 */
	void updateLeaveApplication(String status ,int id) ;
	/**
	 * query all LeaveApplication record 
	 * @param tId
	 * @return
	 */
	List<LeaveApplication> getTeacherLeaveApplication(String teacher);
	
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
