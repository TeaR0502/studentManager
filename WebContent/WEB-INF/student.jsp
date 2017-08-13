<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!student</title>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function () {
		
		$("#submit").click(function () {
			//
			$.ajax({
						url : "Leave_add.html",
						type : "post",//以post方式请求
						data : {
							"askername":$("#askusername").val(),
							"type":$("#AskType").val(),
							"startDate":$("#startDate").val(),
							"endDate":$("#endDate").val(),
							"reason":$("#reason").val()
						},//传参
						dataType : "text",//服务器返回的数据类型
						success : function(data) {
							if (data == 0){
								$("h3").html("提交成功!");
							}
						},
						error : function(e) {
							alert("错误");
						}
					});

			//
		});

		//获取订单的基本信息
		$("#AskForLeave").click(function () {
			//
			$.ajax({
						url : "User_queryByName.html",
						type : "post",//以post方式请求
						data : {
						},//传参
						dataType : "Json",//服务器返回的数据类型
						success : function(data) {
							//alert("123");
							$("#askusername").val(data.realname);
							$("#checkusername").val(data.teacher.username);
						},
						error : function(e) {
							alert("错误");
						}
					});

			//
			//
			$.ajax({
						url : "Type_queryAll.html",
						type : "post",//以post方式请求
						data : {
						},//传参
						dataType : "Json",//服务器返回的数据类型
						success : function(data) {
							//alert(data[0].askTyep);
							var temp = "";
							for (var i = 0;i < data.length; i++){
								temp += "<option value='"+data[i].askTyep+"'>"	

								+data[i].askTyep+"</option>"
								}
							$("#AskType").html(temp);
						},
						error : function(e) {
							alert("错误");
						}
					});

			//
			
			$("#createForm").show(2000);
		});
		$("#startDate").click(function () {
			$("#startDate").val("");
		});
		$("#endDate").click(function () {
			$("#endDate").val("");
		});
		$("#createForm").hide();
	});
</script>
</head>
<body>
	<div align="center">
		<h1>Welcome!<span id="username"></span></h1>	
		<h3></h3>
		<p><a href="exit.html">退出</a> </p>
		<input type="button" value="申请请假" id="AskForLeave">
		<input type="button" value="查看审批结果" id="query">
		<table id="createForm">
			<tr>
				<td>请假人</td>
				<td><input type="text" id="askusername" disabled="disabled" value="正在获取..." /></td>
			</tr>
			<tr>
				<td>审批人</td>
				<td><input type="text" id="checkusername" disabled="disabled" value="正在获取..." /></td>
			</tr>
			<tr>
				<td>假期开始时间</td>
				<td><input type="text" id="startDate"  value="格式YYYY-MM-DD!" /></td>
			</tr>
			<tr>
				<td>假期结束时间</td>
				<td><input type="text" id="endDate"  value="格式YYYY-MM-DD!" /></td>
			</tr>
			<tr>
				<td>请假类型</td>
				<td>
					<select id="AskType">
					
					</select>
				</td>
			</tr>
			<tr>
				<td>请假事由</td>
				<td><textarea rows="30px" cols="80px" id="reason"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="提交申请" id="submit"/></td>
			</tr>
		</table>
	</div>
	
</body>
</html>