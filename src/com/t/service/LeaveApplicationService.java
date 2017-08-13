package com.t.service;

import java.util.Date;

import com.t.entity.AskType;
import com.t.entity.Users;

public interface LeaveApplicationService {
	/**
	 * create a new LeaveApplication Record
	 * @param leaveApplication
	 */
	void addLeaveApplication(Users student,AskType askType,Date startDate,Date endDate,String reason);
}
