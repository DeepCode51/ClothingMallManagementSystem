<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-个人订单结果</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
      <style type="text/css">
          #shopping {width:980px;}
#shopping table { width:100%; line-height:24px; border-top:2px solid #dfc9b2; border-bottom:2px solid #dfc9b2; }
#shopping table th { background:#f7f4eb; color:#8a7152; }
#shopping table td { padding:10px 0; border-top:1px solid #dfc9b2; }
#shopping table td.thumb img { border:1px solid #dfdfe0; margin:0 10px; vertical-align:middle; }
#shopping table td.price,#shopping table td.number { text-align:center; width:100px; border-left:1px solid #e1e1e1; }
#shopping table td.price { color:#cc3300; font-weight:bold; }
#shopping table td.delete { width:60px; text-align:center; border-left:1px solid #e1e1e1; }
#shopping table td.number dl { width:80px; margin:0 auto; }
#shopping table td.number dl dt { float:left; display:inline; width:25px; text-align:center; margin:0 4px; }
#shopping table td.number dl dt input { width:20px; border:1px solid #c9c9c9; padding:2px; text-align:center; }
#shopping table td.number dl dd { float:left; width:28px; margin:3px 0; text-align:center; line-height:20px; height:19px; overflow:hidden; border:1px solid #c9c9c9; cursor:pointer; }
#shopping .button { text-align:right; padding:10px 0; }
#shopping .button input { border:0; background:url(../images/bg.png) left -213px; width:144px; height:35px; cursor:pointer; }
#shopping .shadow { width:500px; margin:50px auto; }
      </style>
	<script language="javascript">

    
      function selectname(){
	  var name = document.getElementById("selectname").value;
	  location.href='selectProductList?name='+name;
     }
    
</script>
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
						<form action="">
						
						</form>
					</div>
				</div>
			</div>
			<div class="header-nav">
				<ul>
				   <li class="nav-item"><a href="index.jsp">首页</a></li>
			       <c:forEach var="f" items="${flist}">
			       <li class="nav-item"><a href="SelectProductServlet?catebigid=${f.cateid}">${f.catename}</a></li>
			       </c:forEach>
					
				</ul>
			</div>
		
		</div>
		<div class="banner">
            <div id="shopping">
            
		
		
		  <h2>更新成功</h2>
		  
	</div>
        <div class="footer">
            <p align="center">宝舒儿童服饰购物网站</p>
        </div>
    </div>
</body>
</html>