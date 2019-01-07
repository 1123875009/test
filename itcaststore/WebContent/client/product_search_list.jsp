<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>bookStore列表</title>
	<%--导入css --%>
	<link rel="stylesheet" href="client/css/main.css" type="text/css" />
</head>
<!-- 显示搜索或分类的商品 -->
<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;全部商品&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>
					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>全部商品</h1>&nbsp;&nbsp;&nbsp;&nbsp;共${bean.totalCount}种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="client/images/productlist.gif" width="100%" height="38" />
								</div>

								<table cellspacing="0" class="booklist">
									<tr>   
									<!-- 遍历商品的列表 用p存储每一个商品对象 -->
										<c:forEach items="${bean.ps}" var="p" varStatus="vs">
											<td>
												<div class="divbookpic">
													<p>
														<a href="${pageContext.request.contextPath}/findProductById?id=${p.id}"><img
															src="${pageContext.request.contextPath}${p.imgurl}"
															width="115" height="129" border="0" /> </a>
													</p>
												</div>
												<div class="divlisttitle">
													<a href="${pageContext.request.contextPath}/findProductById?id=${p.id}">书名： ${p.name}<br />售价：￥${p.price} </a>
												</div>
											</td>
											<%-- <c:if test="${vs.count%4==0}">
											</c:if> --%>
										</c:forEach>
									</tr>
								</table>
								<!-- <table cellspacing="0" class="booklist">
									<tr>
									</tr>
								</table> -->

								<div class="pagination">
									<ul>    <!-- 当前的页码不为1 -->
										<c:if test="${bean.currentPage!=1}">
											<li class="nextPage">
												<a href="${pageContext.request.contextPath}/MenuSearchSerlvet?currentPage=${bean.currentPage-1}&textfield=${bean.searchfield}">&lt;&lt;上一页</a>
											</li>
										</c:if>   <!-- 当前的页码为1，上一页的不能点击 -->
										<c:if test="${bean.currentPage==1}">
											<li class="disablepage">&lt;&lt;上一页</li>
										</c:if>
										<!-- 循环次数放入变量 pagenum中 -->
										<c:forEach begin="1" end="${bean.totalPage}" var="pageNum">
                                            <!-- 判断当前页是否是第几页  显示页码  且此页无链接 -->
											<c:if test="${pageNum==bean.currentPage}">
												<li class="currentpage">${pageNum }</li>
											</c:if>
											<!-- 不为当前页码的页面，显示页码可直接点击页号进行访问 -->
											<c:if test="${pageNum!=bean.currentPage}">
												<li><a href="${pageContext.request.contextPath}/MenuSearchSerlvet?currentPage=${pageNum}&textfield=${bean.searchfield}">${pageNum}</a>
												</li>
											</c:if>

										</c:forEach>
										<!-- 判断此页是否是最后一页 是则无法点击下一页-->
										<c:if test="${bean.currentPage==bean.totalPage||bean.totalPage==0}">
											<li class="disablepage">下一页 &gt;&gt;</li>
										</c:if>
										<!-- 不是则可点击下一页 ，且链接查询当前页的下一页面-->

										<c:if test="${bean.currentPage!=bean.totalPage&&bean.totalPage!=0}">
											<li class="nextpage">
												<a href="${pageContext.request.contextPath}/MenuSearchSerlvet?currentPage=${bean.currentPage+1}&textfield=${bean.searchfield}">下一页&gt;&gt;</a>
											</li>
										</c:if>
									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
