<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
		rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/UpdateMsgboard"
		method="post">
<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="5%">留言序号</td>
								<td align="center" width="8%">留言人</td>
								<td align="center" width="35%">我的留言</td>
								<td align="center" width="12%">留言时间</td>
								<td width="15%" align="center">消息通知</td>
								<td width="8%" align="center">回复</td>
							</tr>
                            <!--  循环输出所有商品  每一个商品都赋值给变量p-->
							<c:forEach items="${msgs}" var="msg">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="5%">
									${msg.msg_id}"</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${msg.username}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="35%">${msg.msgcontent}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="12%">${msg.msgdate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">
									<input type="text" name="replycontent" size="10" value="" />
									</td>
									<td align="center" style="HEIGHT: 22px" width="8%">    <!--编辑按钮，链接为通过id查询商品并且传递参数type 声明请求的来源-->
									   <button type="submit" id="add" name="reply" value="${msg.msg_id}" class="button_add">
							回复
						</button>
									<%-- </td>
									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="${pageContext.request.contextPath}/deleteProduct?id=${p.id}" onclick="javascript:return p_del()">
												<img src="${pageContext.request.contextPath}/admin/images/i_del.gif"
												width="16" height="16" border="0" style="CURSOR: hand">
										</a>
									</td>--%>
								</tr>
							</c:forEach>
						</table>
					</td>
</body>
</html>