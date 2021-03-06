package com.t.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.t.entity.AskType;
import com.t.entity.LeaveApplication;
import com.t.entity.Users;
import com.t.service.AskTypeService;
import com.t.service.LeaveApplicationService;
import com.t.service.UserService;

@Controller
public class LeaveApplicationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9130371722055852741L;
	@Autowired
	private UserService userService;
	@Autowired
	private AskTypeService askTypeService;
	@Autowired
	private LeaveApplicationService leaveApplicationService;
	
	//审批请假单
		public void update() throws IOException{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String status = request.getParameter("status");
			Integer id = Integer.parseInt(request.getParameter("id"));
			System.out.println(status+":"+id);
			leaveApplicationService.updateLeaveApplication(status, id);
			response.getWriter().write("0");
	}
	
	//添加请假单
	public void add() throws IOException {
		System.out.println("进入LeaveApplication_add");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String type  = request.getParameter("type");
		String start  = request.getParameter("startDate");
		String end  = request.getParameter("endDate");
		String reason  = request.getParameter("reason");
		
		
		Users student = userService.queryUserByName(username);
	//	System.out.println(student);
		AskType askType = askTypeService.getType(type);
	//	System.out.println(askType);
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sFormat.parse(start);
			endDate = sFormat.parse(end);
	//		System.out.println(startDate);
	//		System.out.println(endDate);
		} catch (ParseException e) {
			System.out.println("日期格式不正确!");
			e.printStackTrace();
		}
		leaveApplicationService.addLeaveApplication(student, askType, startDate, endDate, reason);
		response.getWriter().write("0");
		
	}
	
	//学生查询请假单
	public void getStudentLeaveApplication() throws IOException {
//		System.out.println("进入getStudentLeaveApplication");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Users student = userService.queryUserByName(username);
//		System.out.println(student);
		List<LeaveApplication> list = leaveApplicationService.getStudentLeaveApplication(student.getId());
		
//		System.out.println("========请假记录======]");
//		for (LeaveApplication leaveApplication : list) {
//			System.out.println(leaveApplication);
//		}	 
//		System.out.println("========请假记录======]");
		if (list != null && list.size() != 0) {
			response.getWriter().write(JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect));
		} else {
			response.getWriter().write("");
		}
		
	}
	
	//老师查询请假单
	public void getTeacherLeaveApplication() throws IOException {
//		System.out.println("进入getTeacherLeaveApplication");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Users teacher = userService.queryUserByName(username);
//		System.out.println("识别当前身份:"+teacher);
		List<LeaveApplication> list = leaveApplicationService.getTeacherLeaveApplication(teacher.getRealname());
		
//		for (LeaveApplication leaveApplication : list) {
//			System.out.println(leaveApplication);
//		}
		 
		if (list != null && list.size() != 0) {
//			System.out.println(JSON.toJSONString(list));
			response.getWriter().write(JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect));
		} else {
			response.getWriter().write("");
		}
		
	}
	
	

}
