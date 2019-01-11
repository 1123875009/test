<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
	<link rel="stylesheet" href="../css/main.css" type="text/css" />
	<script type="text/javascript" src="../js/my2.js"></script>
</head>

<body class="main">
<%@include file="/client/head.jsp"%>
	<div id="divcontent">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding:30px; text-align:center"><table width="60%"
						border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							<td style="width:98">
								<img src="../images/error.jpg" width="128" height="128" />
							</td>
							<td style="padding-top:30px"><font
								style="font-weight:bold; color:#ff0000">您还未登陆！请登录后操作</font><br />
								<br /> 
								<a href="${pageContext.request.contextPath }/client/login.jsp">
									<span id="second">5</span>秒后自动为您转到登录界面
								</a>
							</td>
						</tr>
					</table>
					<h1>&nbsp;</h1>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
