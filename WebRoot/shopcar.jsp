<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-购物车</title>
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
				   <li class="nav-item"><a href="ShopServlet">购物车</a></li>
				</ul>
			</div>
		
		</div>
		<div class="banner">
            <div id="shopping">
		       <form action="FinshOrderServlet" method="post">
                   <table>
                       <tr><th>商品名称</th><th>商品价格</th><th>购买数量</th><th>操作</th></tr>
                       <c:forEach var="c" items="${requestScope.shoplist}">
                           <tr id="product_id_1">
                               <td class="thumb">
                                   <input type="checkbox" name="op" onclick="dxcheck()"> <!-- 选框 -->
                                   <img src="images/cloth/${c.propname}" height="100" width="100" />
						           <a href="SelectProImgServlet?proid=${c.proid}">${c.proname}</a>
						       </td> 
                               <td class="price" id="price_id_1">
                                   <span id="priceText" name="priceText" >${c.proprice}</span>
		           <!-- 商品单价 --><input type="hidden" name="proprice" value="${c.proprice}" />
                   <!-- 购物单id --><input type="hidden" name="carid" value="${c.carid}" />
                     <!-- 商品id --><input type="hidden" name="proid" value="${c.proid}" />
						       </td>
                               <td class="number">
                                   <input type="button"  value="-" onclick="jian1(${c.carid},${c.procount})" /> 
			      <!-- 购买数量 --><input id="${c.carid}" type="text" name="procount" value="${c.procount}"  onblur="closeText(id,${c.prostock})" />
                                   <input type="button"  value="+" onclick="jia1(${c.carid},${c.procount},${c.prostock}) " />
                               </td>
                               <td class="delete"><a href="javascript:del(${c.carid});">删除</a>&nbsp;&nbsp;
                               <a href="FinshOrderServlet?carid=${c.carid}">结算</a>
                               </td>
                               
                           </tr>
                       </c:forEach>
                   </table>
                   <input type="checkbox" onclick="qxcheck()" name="op2" />全选 
                   <div align="right" >总价钱:<span id="zdzj">0</span>元</div>
                   <input type="hidden" name="jstext" id="jstext" value="0" />
                   <div align="center"><span id="xzText">请选择物品！！！</span></div>
                   <div class="button"><input style="display:none;" type="submit" value="结算" id="jsbutton"  /></div>
                </form>
            </div>
        </div>
        
    </div>
        <div class="footer">
            <p align="center">宝舒儿童服饰购物网站</p>
        </div>
    
</body>
</html>