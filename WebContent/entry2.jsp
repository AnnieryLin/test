<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="net.lgs.domain.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
	<style type="text/css">
		html, body { width:100%; height:100%; font-family:'Open Sans', sans-serif; background-color:#8abcd1; }
		#logout { text-align:right; padding:0px 30px 10px 30px; }
		#menu { width:290px; height:100%; border:1px solid grey; float:left; background-color:#c3d7df; }
		#menu li { list-style-type:none; }
		#page { width:1200px; height:100%; border:1px solid grey; float:left; background-color:#d0dfe6; }
		iframe { width:1200px; height:100%; }
	</style>
</head>

<body>
<h3> 车载终端信息安全标准检测结果录入系统</h3>
<div id="logout">
	<% User user = (User)session.getAttribute("user"); %>
	当前用户: <%=user.getName() %> <a href="logout">退出</a>
</div>
<div id="menu">
	<ul>
		<li><a href="insert" target="mainFrame">录入检测结果</a></li>
		<li><a href="query" target="mainFrame">查看历史检测记录</a></li>
	</ul>
</div>
<div id="page">
	<iframe src="insert" name="mainFrame"></iframe>
</div>
</body>
</html>