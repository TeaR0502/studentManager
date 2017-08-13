package com.t.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.t.entity.Users;
import com.t.service.UserService;

@Controller
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3175767041826926837L;
	@Autowired
	private UserService userService;
	
	/**
	 * 查询并返回用户信息
	 * @throws IOException
	 */
	public void queryByName() throws IOException {
		System.out.println("进入ACTION");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println("获取用户名:"+username);
		Users users = userService.queryUserByName(username);
		if (users != null) {
			response.getWriter().write(JSON.toJSONString(users));
		} else {
			response.getWriter().write("");
		}
	}

	/**
	 * 退出
	 * @throws IOException
	 * @throws ServletException
	 */
	public void exit() throws IOException, ServletException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");

	}

	/**
	 * 验证登录
	 * @throws IOException
	 * @throws ServletException
	 */
	public void login() throws IOException, ServletException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String uname = request.getParameter("username");
		String upass = request.getParameter("password");
		System.out.println("用户名:" + uname + ",密码:" + upass);
		System.out.println(userService);
		if (userService.UsersLogin(uname, upass)) {
			System.out.println("登录成功");
			request.getSession().setAttribute("username", uname);
			response.getWriter().write("0");
		} else {
			System.out.println("登录失败");
			response.getWriter().write("1");
		}

	}

	/**
	 * 访问页面
	 * @throws IOException
	 * @throws ServletException
	 */
	public void loginSuccess() throws IOException, ServletException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null || username.equals("")) {
			response.sendRedirect("index.jsp");
		} else {
			Users users = userService.queryUserByName(username);
			if (users == null) {
				response.sendRedirect("index.jsp");
			} else if (users.getJob().equals("老师")) {
				request.getRequestDispatcher("WEB-INF/teacher.jsp").forward(request, response);
			} else if (users.getJob().equals("学生")) {
				request.getRequestDispatcher("WEB-INF/student.jsp").forward(request, response);
			}
		}

	}
}
