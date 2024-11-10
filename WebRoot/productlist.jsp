<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-商品</title>
	<link rel="stylesheet" type="text/css" href="css/product.css">
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
			       <c:forEach var="f" items="${flist}">
			       <li class="nav-item"><a href="SelectProductServlet?catebigid=${f.cateid}">${f.catename}</a></li>
			       </c:forEach>
					
				</ul>
			</div>
		
		</div>
		<div class="banner">
         <div class="lefterbox">
		   <div class="firstbox">
			<h2>商品分类</h2>
			<ul>
				<li class="fli"><a href="SelectProductServlet">全部商品</a></li>
				<c:forEach var="f" items="${flist}">
					<li><a href="SelectProductServlet?catebigid=${f.cateid}">${f.catename }</a></li>
					<c:forEach var="c" items="${clist}">
						<c:if test="${c.catebigid==f.cateid}">
                            <li class="cli">
                                <a href="SelectProductServlet?catechildid=${c.cateid }">${c.catename }</a></li>
	
						</c:if>
					</c:forEach> 
				</c:forEach> 
			</ul>
		  </div>

	
        </div>
            <div class="main">
                <h1>您现在的位置：<a href="index.jsp">商城</a> &gt; 
                    <a href="SelectProductServlet">商品分类</a> &gt;${title}</h1>
                <div class="productlist">
                    <ul class="product clearfix">
                        <c:forEach var="pro" items="${list}">
                            <li>
                                <dl>
                                    <dt><a href="SelectProImgServlet?proid=${pro.proid}" target="_blank"><img src="images/cloth/${pro.propname}" /></a></dt>
                                    <dd class="title">
                                        <a href="SelectProImgServlet?proid=${pro.proid}" target="_blank">${pro.proname}</a>
                                    </dd>
                                    <dd class="price">￥${pro.proprice}.00</dd>
						        </dl>
					        </li>
                        </c:forEach>
                    </ul>
                    <div class="pager">
                        <ul class="clearfix">
                            <li>当前:${cpage}/${tpage}页</li>
				            <li><a href="SelectProductServlet?cp=1">首页</a></li>
				            <li><a href="SelectProductServlet?cp=${cpage-1<=0 ? 1 : cpage-1 }">上一页</a></li>
				            <li><a href="SelectProductServlet?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a></li>
				            <li><a href="SelectProductServlet?cp=${tpage }">尾页</a></li>
				            <li>
                                <select onchange="jump(this.value)">
                                    <c:forEach var="i" begin="1" end="${tpage}">
                                        <option ${i==cpage ? "selected" : "" } value="${i}">${i }页</option>
                                    </c:forEach>
                                </select>
                            </li>
                        </ul>
                    </div>
		        </div>
		    </div>

		
	
        </div>
    </div>
    <div class="footer">
        <p align="center">宝舒儿童服饰购物网站</p>
    </div>
    
</body>
</html>