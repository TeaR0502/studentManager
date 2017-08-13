<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function () {
		//alert(123);
		
	
		
		//获取页面信息
		$.ajax({
 			async : false,
			url : "Leave_getTeacherLeaveApplication.html",
			type : "post",//以post方式请求
			data : {
			},//传参
			dataType : "Json",//服务器返回的数据类型
			success : function(data) {
				if (data == ""){
					$("#showForm").html("<tr>没有您审批的请假单</tr>");
				} else{
					//alert(data[0].status);
					$("h3").html("需要"+data[0].teacher+"审批的请假记录!");
					var temp="<tr><td>请假单编号</td><td>请假类型</td><td>请假人</td><td>开始日期</td><td>结束日期</td><td>请假原因</td><td>审核结果</td></tr>";
					for (var i = 0 ; i < data.length ; i++ ){
						//alert(data[i].asker.username);
						var startDate = new Date();
						startDate.setTime(data[i].startDate);
						var endDate = new Date();
						endDate.setTime(data[i].endDate);
						temp += "<tr>"
						+"<td>"+ data[i].id+"</td>"
						+"<td>"+ data[i].askType.askTyep+"</td>"
						+"<td>" +data[i].asker.username+"</td>"
						+"<td>" + startDate.toLocaleDateString() + "</td>"
						+"<td>" + endDate.toLocaleDateString() + "</td>"
						+"<td>" + data[i].reason + "</td>";

						if (data[i].status == "未审核"){
						temp += "<td id='"+data[i].id+"' >"+"<input name='"+data[i].id+"' type='button' value='同意' class='agreebutton'/>"
						+"<input name='"+data[i].id+"' type='button' value='驳回' class='refusebutton'/>" + "</td></tr>";
						} else if (data[i].status == "同意") {
							temp += "<td style='color:green'>已批准</td></tr>";
						} else if (data[i].status == "驳回") {
							temp += "<td style='color:red'>已驳回</td></tr>";
						}
						
						
					}
					$("#showForm").html(temp);
					$("#showForm").show(2000);
					
				}
			},
			error : function(e) {
				alert("错误");
			}
		});
		//






		$(".refusebutton").click(function () {
			//alert(123);
			//alert($(this).attr("name"));
			$("#"+$(this).attr("name")).html("<td style='color:red'>已驳回</td></tr>");
				//
			$.ajax({
				url : "Leave_update.html",
				type : "post",//以post方式请求
				data : {
					"status":"驳回",
					"id":$(this).attr("name")
				},//传参
				dataType : "text",//服务器返回的数据类型
				success : function(data) {
					if (data == 0){
						
						$("#"+$(this).attr("name")).html("<td style='color:red'>已驳回</td></tr>");
					}
				},
				error : function(e) {
					alert("错误");
				}
			});
			//
			
		});
		
		$(".agreebutton").click(function () {
			//alert(123);
			//alert($(this).attr("name"));
			$("#"+$(this).attr("name")).html("<td style='color:green'>已批准</td></tr>");
			//
			$.ajax({
				url : "Leave_update.html",
				type : "post",//以post方式请求
				data : {
					"status":"同意",
					"id":$(this).attr("name")
				},//传参
				dataType : "text",//服务器返回的数据类型
				success : function(data) {
					if (data == 0){
						
						$("#"+$(this).attr("name")).html("<td style='color:green'>已批准</td></tr>");
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
<title>Welcome!</title>
</head>
<body>
	<div align="center">
		<h1>Welcome!teacher!</h1>
		<h3></h3>
		<p><a href="exit.html">退出</a> </p>
		<div ><table id="showForm"></table></div>
		<div id="reason"></div>
	</div>
</body>
</html>