<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#button")
				.click(
						function() {
							//alert("输入的用户名为:" + $("#username").val() + "输入的密码为:"
							//		+ $("#password").val());
							//
							$.ajax({
										url : "User_login.html",
										type : "post",//以post方式请求
										data : {
											"username" : $("#username").val(),
											"password" : $("#password").val()
										},//传参
										dataType : "text",//服务器返回的数据类型
										success : function(data) {
											if(data == 1){
												$("h3").html("用户名或密码错误!");
											} else if(data == 0){
												window.location.href="welcome.html";
											}
										},
										error : function(e) {
											alert("错误");
										}
									});

							//

						});

	});
</script>
<title>欢迎访问教务系统</title>
</head>
<body>
	<div align="center">
		<h1>请先登录</h1>
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" id="username"></td>
			</tr>
			<tr>
				<td>密 码</td>
				<td><input type="password" id="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" id="button" value="登录"></td>
			</tr>
		</table>
		<h3></h3>
	</div>

</body>
</html>