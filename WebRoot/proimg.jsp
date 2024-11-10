<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-商品详情</title>
    <link rel="stylesheet" type="text/css" href="css/product.css">
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
                                        <a href="SelectProductServlet?catechildid=${c.cateid }">${c.catename }</a>
                                    </li>
                                </c:if>
                            </c:forEach> 
				        </c:forEach> 
			         </ul>
		        </div>

            </div>
            <div class="main">
                <h1>您现在的位置：<a href="index.jsp">商城</a> &gt; 
                    <a href="SelectProductServlet">商品分类</a> &gt;
                    <c:if test="${pro.catebigid>0}">
                        <c:forEach var="f" items="${flist}">
                            <c:if test="${pro.catebigid==f.cateid}">
			                    ${f.catename}&gt;
			                 </c:if>
                        </c:forEach>
                    </c:if>
                    ${pro.proname}
                </h1>
                <div id="product">
                    <div class="infos">
                        <div id="magnifier">
                            <img src="images/cloth/${pro.propname}" />
                        </div>
                        <div class="buy">
                            <p>名称：<span class="name">${pro.proname}</span></p>
                            <p>价格：<span class="price">￥${pro.proprice}.00</span></p>
                            <p>发货方式：快递</p>
				            <p>库　存：<span id="stock">${pro.prostock}</span></p>
				            <p>购买数量：
				            <input type="button" value=" - " onclick="jian()">
                            <input align="middle" type="text" value="1" id="count" name="count" onblur="checkcount()">
				            <input type="button" value=" + " onclick="jia()"/></p>
				            <div class="button">
                                <a href="javascript:shopAdd2(${pro.proid})"">放入购物车</a>
                            </div>
                        </div>
		            </div>
		            <div class="introduce">
                        <h2>商品详情</h2>
                        <div class="text">${pro.prodetail}</div>
                        <h2>最新评论</h2>
                        <div class="text"><c:if test="${pro.codetail!=null}">${pro.codetail}</c:if>
                        <c:if test="${pro.codetail==null}">暂无评论</c:if></div>
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