<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/check.js"></script>
</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/EditPictureServlet" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${pic.id}" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
					<strong>编辑商品</strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="title" class="bg" value="${pic.title}" />
				</td>
			</tr>
			<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">原商品图片：</td>
			<td class="ta_01" bgColor="#ffffff">
			<img width="200px" height="120px" src="${pageContext.request.contextPath}${pic.imgurl}" width="16" height="16" border="0" style="CURSOR: hand"></td>
	
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">修改商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
				<input type="file" name="upload" size="30" value="" /></td>
			</tr>
			
			<TR>
				<td align="center" colSpan="4" class="sep1">
					<img src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定"> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel" /> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>