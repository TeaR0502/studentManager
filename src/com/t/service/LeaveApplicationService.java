package com.t.service;

import java.util.Date;
import java.util.List;

import com.t.entity.AskType;
import com.t.entity.LeaveApplication;
import com.t.entity.Users;

public interface LeaveApplicationService {
	/**
	 * query all LeaveApplication record
	 * @return
	 */
	List<LeaveApplication> getStudentLeaveApplication(int stuId);

	
	/**
	 * create a new LeaveApplication Record
	 * @param leaveApplication
	 */
	void addLeaveApplication(Users student,AskType askType,Date startDate,Date endDate,String reason);
}
