<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>电子书城</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
</head>
<body class="main">
	<!-- 使用了自定义标签  这里的标签实际上是执行了PrivilegeTag.class中的代码段，判断用户是否有权限进行操作-->
	<p:user/>
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0" style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd">
								<img src="${pageContext.request.contextPath }/client/images/icon1.png" width="15" height="10" />
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="${pageContext.request.contextPath }/client/modifyuserinfo.jsp">用户信息修改</a>
							</td>
						</tr>
						<tr>
							<td class="listtd">
								<img src="${pageContext.request.contextPath }/client/images/icon2.png" width="15" height="10" />
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="${pageContext.request.contextPath}/findOrderByUser">订单查询</a>
							</td>
						</tr>
						
						<tr>
							<td class="listtd">
								<img src="${pageContext.request.contextPath }/client/images/icon2.png" width="15" height="10" />
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="${pageContext.request.contextPath}/FindScoreByUser">积分查询</a>
							</td>
						</tr>
						
						<tr>
							<td class="listtd">
								<img src="${pageContext.request.contextPath }/client/images/icon3.png" width="15" height="10" />
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="${pageContext.request.contextPath}/logout">用户退出</a>
							</td>
						</tr>
					</table>
				</td>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/client/myAccount.jsp">&nbsp;我的帐户</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;
						积分查询
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td style="padding:20px"><p><b>我的积分</b></p>
								
								<table width="100%" border="0" cellspacing="0" class="tableopen">
									<tr>
										<td bgcolor="#A3E6DF" class="tableopentd01">用户</td>
										<td bgcolor="#A3E2E6" class="tableopentd01">积分</td>
									</tr>
								
									
										<tr>
											<td class="tableopentd02">${user.username}</td>
											<td class="tableopentd02">${user.score}</td>	
										</tr>
									
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="foot.jsp" %>
</body>
</html>