<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-个人订单</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
      <style type="text/css">
          #register { clear:both;
            padding:20px;
            height:400px;}
          #register .shadow { width:599px; margin:0 auto; border-color: #999999;background-color: white;}
          #register .steps li { float:left; line-height:25px; background-color:#dbdbdb; width:292px; text-align:center; color:#999; }
          #register .steps li.finished { background:#ffdc9a; }
          #register .steps li.finished em { width:24px; background-position:-51px -90px; }
          #register form { clear:both; ;margin:0px auto }
          #register form table { width:100%; }
          #register form table td { padding:10px 0; }
          #register form table td.field { width:220px; text-align:right; font-size:14px; }
          #register form table td input.text { border-left:1px solid #686868; border-top:1px solid #686868; border-bottom:1px solid #b6b6b6; border-right:1px solid #b6b6b6; padding:3px 4px; width:200px; }
          #register form table td input.verycode { width:120px; }
          #register form table td #veryCode { vertical-align:middle; width:70px; height:23px; margin-left:10px; }
          #register form table td span { display:none; vertical-align:middle; margin-left:10px; padding-left:22px; padding-right:10px; background:url(../images/bg.png) -232px -63px no-repeat; }
          #register form table td span.error { display:inline-block; border:1px solid #ff835a; background-color:#ffe8e0; }
          #register form table .current { background:#edffd5; }
          #register form label.ui-green { height:30px;}
          #register form label.ui-green input { font-size:18px; font-weight:bold; line-height:32px; height:30px; padding:0 15px; }
         
      </style>
	
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
            <div id="register">
	<div class="shadow">
		
		<div class="box">
			<form method="get" action="UpdateCommentServlet" >
				<table>
				    <tr>
						<td class="field">订单id：<input type="hidden" name="otid" value="${o.otid}"/><input type="hidden" name="userid" value="${name.userid}"/></td>
						<td>${o.otid}</td>
					</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td>${o.proname}</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><img src="images/cloth/${o.propname}"  height="50" width="50"/></td>
					</tr>
					
					
					<tr>
						<td class="field">评价：</td>
						<td><textarea rows="8" cols="20" name="codetail"/></textarea></td>
					</tr>
					
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" id="sub" value="提交" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
		</div>
                   
			
		
	        </div>
            <div class="footer">
                <p align="center">宝舒儿童服饰购物网站</p>
            </div>
       </div>
</body>
</html>