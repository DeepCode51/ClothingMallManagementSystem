<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-个人订单</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="scripts/function.js"></script>
 
</head>

<body>
	<div id="suber">
		<div class="top clearfix">
		    <ul id="leftlink">
				<li><c:if test="${name==null}"><a href="login.jsp">登录&nbsp;&nbsp;&nbsp;</a></c:if></li>
				<li><a href="reg.jsp">&nbsp;&nbsp;&nbsp;注册新用户</a></li>
				<li><c:if test="${name!=null}">欢迎您！${name.username}</c:if></li>
			</ul>
			<ul id="rightlink">
			     <li><a href="ShopServlet" id="a1">购物车</a></li>
				<li><c:if test="${name!=null}"><a href="SelectOrderServlet?dd=${name.username}" id="a2">订单管理</a></c:if></li>
				<li><a href="usercenter.jsp" id="a3">个人中心</a></li>
		        <li><a href="OutServlet" id="a4">退出</a></li>
			</ul>
		
		</div>
		<div class="header clearfix">
			<div class="header-top clearfix">
				<div class="logo fl">
					<img src="images/logo.jpg" alt="">
				</div>
				<div class="info fr">
					
				  <div class="fr">
						<form action="SelectProductServlet" method="get">
						<input type="text" placeholder="请输入检索关键词" class="search-form" value="T恤" name="selectname">
						<input type="submit" value="搜索" id="searchname">
					    </form>
					</div>
				</div>
			</div>
			<div class="header-nav">
				<ul>
				   <li class="nav-item"><a href="IndexServlet">首页</a></li>
				   <li class="nav-item"><a href="SelectOrderServlet?dd=${name.username}">我的订单</a></li>
				   <li class="nav-item"><a href="SelectCommentServlet?dd=${name.username}">我的评价</a></li>
				</ul>
			</div>
		
		</div>
		<div class="banner">
            <div id="shopping">
            <c:if test="${not empty comment}">
                   <table>
                       <tr><th>评价编号</th><th>订单详情编号</th><th>商品名称</th><th>评价信息</th><th>操作</th></tr>
                       <c:forEach var="co" items="${comment}">
					    <tr align="center">
						  <td>${co.coid}</td>
						  <td>${co.otid}</td>
						  <td>
						  <img src="images/cloth/${co.propname}"  height="50" width="50"/>
						  ${co.proname}
						  </td>
						  <td>${co.codetail}</td>
						  <td class="delete"><a href="javascript:delco(${co.coid});">删除</a></td>
					    </tr>
					</c:forEach>
				
			      </table>
			
		</c:if>
		<c:if test="${comment==null}">
		<div >
		  <h2>无评价信息</h2>
		  <a href="ShopServlet">快去评价吧</a>
		</div>
		</c:if>
	</div>
	</div>
	</div>
        <div class="footer">
            <p align="center">宝舒儿童服饰购物网站</p>
        </div>
    
</body>
</html>