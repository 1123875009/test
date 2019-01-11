<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
<!--
function checkresult(textName){
	  
		  var txtTemp = eval(textName).value;  
		  if(txtTemp.length==0)
		  {  
		   alert("请输入留言！");
		   eval("document.forms[0]." + textName).focus();
		   return false;
		  }  
}
-->

</script>
<title>留言板</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style>

a,a:hover { text-decoration: none; }
body {    margin: 0;
    padding: 0;
    font-family: "Helvetica Neue", Arial, "Hiragino Sans GB", "WenQuanYi Micro Hei", "Microsoft YaHei", sans-serif;
    font-size: 100%;
    line-height: 1.5;
    color: #666;
}



.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}
.clearfix:after { clear: both; }
/*for IE6/7*/
.clearfix { *zoom: 1; }


.mes-board {
    margin: 1.875em 0;
    border: 1px solid #aaa;
    padding: 0 .7em;
    background-color: #FFFACD;
}
.mes-board li { padding: .7em 0; }
.mes-board li + li { border-top: 1px dashed #fff; }
.mes-board h4 {
    display: inline;
    margin-right: 2px;
    font-weight: 400;
    color: #66f;
}
.mes-board small { color: #999; }
.mes-board p {
    padding: 1em 0;
 
}


/*Main*/
.wrap {
    padding: 0;
    margin: 0 auto;
    width: 56.25em;
background-color:#afd1f3;
}
/*mes-send*/
.mes-send {
    padding: .65em;
    border: 1px solid #ccc;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
}
.form-group { padding: 1.25em; }
.form-group label { vertical-align: top; }
.mes-send input[type="text"]{
    padding: 1px;
    width: 40%;
    border: 1px solid #b7b7b7;
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}

.mes-send textarea {
    padding: 1px;
    width: 40%;
    height:100px;
    border: 1px solid #b7b7b7;
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}
.mes-send input { height: 2em; }
.btn_msg {
    margin-left: 1.25em;
    padding: 5px;
    border: none;
    -webkit-border-radius: 1.25em;
    -moz-border-radius: 1.25em;
    border-radius: 1.25em;
    width: 15%;
    font-size: 12pt;
    color: #fff;
    background-color: #66f;
    cursor: pointer;
}
.btn_msg:hover { background-color: #03c; }


</style>
</head>
 
<body bgcolor="#FFFFFF" text="#000000">
<%@include file="head.jsp"%>
	<%@include file="menu_search.jsp" %>
	 <div class="wrap">
	 <div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;留言板
					</div>
<section class="mes-send">
    <form method="post" action="${pageContext.request.contextPath}/AddMsgboardServlet">
    
        <div class="form-group">
            <label for="user_name">用户名：</label>
            <input type="text" id="user_name" name="username" value="${sessionScope.user.username}" >
         </div>
         <div class="form-group">
            <label for="user_mes">留言板：</label>
            <textarea id="user_mes" name="msgcontent"></textarea>
         </div>
         <input class="btn_msg" type="submit" value="提 交" onclick="return checkresult(msgcontent)">
         
    </form>
</section>
<%-- 
<ul class="mes-board">
<c:forEach items="${ms}" var="m">
            <li class="mes-content">
                <h4>${sessionScope.user.username}</h4>
                <small>${m.msgdate}</small>
                <p>${m.msgcontent}</p></br>
                <p>${m.msgreply}</p>
            </li>
    </c:forEach>
        </ul>
--%>
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								
								<td align="center" width="8%">留言人</td>
								<td align="center" width="35%">留言内容</td>
								<td align="center" width="12%">留言时间</td>
								<td width="15%" align="center">回复内容</td>
				
							</tr>
                            <!--  循环输出所有商品  每一个商品都赋值给变量p-->
							<c:forEach items="${ms}" var="msg">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${msg.username}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="35%">${msg.msgcontent}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="12%">${msg.msgdate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">
									${msg.msgreply}
									</td>
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
</div>
	<%@include file="foot.jsp"%>
</body>
</html>