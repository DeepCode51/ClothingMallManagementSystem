<%@ page language="java" import="java.util.*,Bean.Chart" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台-首页</title>
	<link rel="stylesheet" type="text/css" href="css/product.css">
	<style type="text/css">
	.firstbox li { 
			font-weight:550; 
			padding:2px 20px; 
			margin-top: 15px;
			margin-bottom: 15px;
		}
	
	</style>
      
</head>

<body>
	<div id="suber">
		<div class="top clearfix">
		    <ul id="leftlink">
				<li><c:if test="${name==null}"><a href="login.jsp">登录 &nbsp;&nbsp;&nbsp;</a></c:if></li>
				<li><c:if test="${name!=null}">当前用户${name.username}</c:if></li>
			</ul>
			<ul id="rightlink">
				<li><a href="admin/admincenter.jsp" id="a3">个人中心</a></li>
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
						<form action="">
						
						</form>
					</div>
				</div>
			</div>
			<div class="header-nav">
				<ul>
				    <li class="nav-item"><a href="Mindex.jsp">首页</a></li>
					<li class="nav-item"><a href="UserShowServlet">信息管理</a></li>
					<li class="nav-item"><a href="ProductShowServlet">商品管理</a></li>
					<li class="nav-item"><a href="OrderShowServlet">订单管理</a></li>
				</ul>
			</div>
		
		</div>
		<div class="banner">
         <div class="lefterbox">
		   <div class="firstbox">
			<h2>信息管理</h2>
			<ul>
				<li><a href="UserShowServlet">查看用户</a></li>
				<li><a href="admin/sale.jsp">查询销售额</a></li>
			</ul>
			<h2>商品管理</h2>
			<ul>
				<li><a href="ProductShowServlet">商品管理</a></li>
				<li><a href="CategoryShowServlet">类目管理</a></li>

			</ul>
			<h2>订单管理</h2>
			<ul>
				<li><a href="OrderShowServlet">订单处理</a></li>
                <li><a href="CommentShowServlet">查看评价</a></li>
			</ul>
			
			
		  </div>
		

	
        </div>
            <div class="main">
            
           
            <div>
		<%String fileName =Chart.generateBarChart(session); //调用生成图表的Java类，返回柱状图png文件的文件名%>
	    <!--设置图片路径：（servlet的url-pattern）？filename=（上面获取的文件名fileName）  -->
	    <img src="DisplayChart?filename=<%=fileName%>" class="chartimg">
		
		
		</div>
               
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