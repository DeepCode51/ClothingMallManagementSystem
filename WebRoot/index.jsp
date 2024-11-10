<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-首页</title>
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
				<li><c:if test="${name!=null}"><a href="usercenter.jsp" id="a3">个人中心</a></c:if></li>
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
			       <c:forEach var="f" items="${flist}">
			       <li class="nav-item"><a href="SelectProductServlet?catebigid=${f.cateid}">${f.catename}</a></li>
			       </c:forEach>
					
				</ul>
			</div>
		
		</div>
		<div class="banner">
            <div class="containter">
                <div id="block1">
                    <h3>当季热卖</h3>
                    
                    <ul>
                        <c:forEach var="hpro" items="${hlist}">
                           <li><a href="SelectProImgServlet?proid=${hpro.proid}"><img src="images/cloth/${hpro.propname}" /></a></li>
                        </c:forEach> 
                    </ul>
                </div>
                <div id="block2">
                    <h3>低价热销</h3>
                    <ul>
                        <c:forEach var="lpro" items="${llist}">
                           <li><a href="SelectProImgServlet?proid=${lpro.proid}"><img src="images/cloth/${lpro.propname}" /></a></li>
                        </c:forEach> 
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer">
            <p align="center">宝舒儿童服饰购物网站</p>
        </div>
    </div>
</body>
</html>