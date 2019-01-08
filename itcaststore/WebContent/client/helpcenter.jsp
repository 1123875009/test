<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
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



/*Main*/
.wrap {
    padding: 0;
    margin: 0 auto;
    width: 56.25em;
background-color: #fcf;
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
<section class="mes-send">
    <form method="post" action="${pageContext.request.contextPath}/UpdateMsgboard">
        <div class="form-group">
            <label for="user_name">用户名：</label>
            <input type="text" id="user_name" name="username" value="${sessionScope.user.username}" >
         </div>
         <div class="form-group">
            <label for="user_mes">留言板：</label>
            <textarea id="user_mes" name="msgcontent"></textarea>
         </div>
         <input class="btn_msg" type="submit" value="提 交">
    </form>
</section>
</div>
	
</body>
</html>