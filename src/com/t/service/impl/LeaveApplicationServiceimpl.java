package com.t.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t.dao.LeaveApplicationDAO;
import com.t.entity.AskType;
import com.t.entity.LeaveApplication;
import com.t.entity.Users;
import com.t.service.LeaveApplicationService;

@Service
public class LeaveApplicationServiceimpl implements LeaveApplicationService{

	@Autowired
	private LeaveApplicationDAO leaveApplicationDAO;
	
	
	@Override
	public void addLeaveApplication(Users student,AskType askType,Date startDate,Date endDate,String reason) {
		LeaveApplication leaveApplication = new LeaveApplication();
		leaveApplication.setAsker(student);
		leaveApplication.setTeacher(student.getTeacher().getRealname());	
		leaveApplication.setAskType(askType);
		leaveApplication.setStartDate(startDate);
		leaveApplication.setEndDate(endDate);
		leaveApplication.setReason(reason);
		leaveApplication.setStatus("未审核");
		//System.out.println(leaveApplication);
		leaveApplicationDAO.addLeaveApplication(leaveApplication);
	}


	@Override
	public List<LeaveApplication> getStudentLeaveApplication(int stuId) {
		// TODO Auto-generated method stub
		return leaveApplicationDAO.getStudentLeaveApplication(stuId);
	}

}
