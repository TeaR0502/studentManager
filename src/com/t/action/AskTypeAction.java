package com.t.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.t.service.AskTypeService;
import com.t.service.UserService;

@Controller
public class AskTypeAction extends ActionSupport{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6486059734320800867L;
	@Autowired
	private AskTypeService askTypeService;

	public void queryAll() throws IOException {
		System.out.println("进入AskTypeAction");
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println(JSON.toJSONString(askTypeService.queryAll()));
		response.getWriter().write(JSON.toJSONString(askTypeService.queryAll()));
	}
}
