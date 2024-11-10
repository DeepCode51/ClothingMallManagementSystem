<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-修改个人信息</title>
	
      <style type="text/css">
      
      *{
			margin: 0;
			padding: 0;
		}
		
		body{background-color:#f2f2f2f2;}
		
		#suber{
			width: 1080px;
			margin: 0 auto;
			clear: both;
		}
		.top{
			height:44px;
			line-height: 44px;
			margin: 0 20px;
		}
		ul{
			list-style-type: none;
		}
		.top li{
			float: left;
		}
		.top #leftlink a{
			 padding-right: 10px;
		}
		.top #rightlink{
			float: right;
		}
		.top #rightlink a{
			padding-left: 10px;
			margin-left: 10px;
		}
		.top a{
			text-decoration: none;
			color: #666666;
			font-size: 12px;
		}
		.top a:hover{
			color:#E85F61;
		}
		
		.clearfix:after{
			content: "";
			display: block;
			clear: both;
		}
		.header{
			width: 1080px;
			background-color: white;
			border-radius: 5px;
			border-bottom-right-radius: 0px;
			border-bottom-left-radius: 0px;
			
		}
		.header-top{
			margin: 0 1.5em 0;
			border-bottom: 3px solid #c31114;
		}
		.logo{
			margin:22px 0 18px;
			clear:both;
		}
		.info{
			margin:46px 0 20px;
		}
		.fl{
			float: left;
		}
		.fr{
			float:right;
		}
		
		.search-form{
			
			height: 33px;
			width: 350px;
			border:1px solid #666;
			border-radius: 5px;
			line-height: 33px;
			margin-left: 1.5em;
			padding-left: 8px;
			float:right;
			color:#C2C2C2;
		}
		#searchname {
              display:inline-block;
              height:30px;
			  width:80px;
			  border:0;
              position: relative;
              top:2px;
              left:375px;
              text-decoration:none;
              background-color: white;
              border-left:1px solid #666;
              
          }
		.header-nav{
			position: relative;
		}
		.nav-item{
			float: left;
			width: 12.5%;
			text-align: center;
			height: 58px;
			line-height: 58px;
			font-size: 16px;
		}
		.nav-item:hover .submenu{
			display: block;
		}
		.nav-item>a{
			text-decoration: none;
			color: #000;
		}
	
		.banner{
			width: 1080px;
			min-height:450px;
			height: auto;
			background-color: white;
			margin-top: 20px;
			
		}
		.leftbox{
			width: 200px;
			height: auto;
		}
		.firstbox{
			margin: 0 auto;
			width: 200px;
			background:#fafafa;
		}
		.secondbox{
			margin: 0 auto;
			width: 200px;
			height:200px;
			background:#fafafa;
			
		}
		.leftbox h2 {
			background:#fff0d9; 
			font-size:16px; 
			color:#853200;
			padding:5px 20px; 
		}
        .firstbox li { 
			font-weight:bold; 
			padding:2px 20px; 
			margin-top: 10px;
		}
        
        .firstbox li a { 
			color:#666;
			text-decoration:none;
		} 
		.secondbox li { 
			margin: 5px;
			float: left;
			width: 90px;
			
		}
 
        .secondbox a { 
			color:#666;
			text-decoration:none;
		}
		.secondbox img{
			margin: 10px;
		}
		.sbox{
			word-wrap:break-word;
		}
		 #block1{
            width:900px;
            height:350px;
            clear:both;
            margin: 10px auto;
        }
        #block1  h3{padding:30px 0px 20px 5px;}
        #block1 ul{list-style-type:none;margin: 10px auto;}
        #block1 ul li{
            float:left;
            width: 180px;
            margin: 10px 20px;} 
        #block1 img{
            float:left;
            width: 180px;
            height: 120px;
        }
        #block2{
            width:900px;
            height:350px;
            clear:both;
            margin: 10px auto;}
        #block2  h3{padding:30px 0px 20px 5px;}
        #block2 ul{list-style-type:none;margin: 10px auto;}
        #block2 ul li{
            float:left;
            width: 180px;
            margin: 10px 20px;
        } 
        #block2 img{
            float:left;
            width: 180px;
            height: 250px;
        }
        .containter{
            width:1080px;
            margin:0px auto;
            overflow: hidden;
        }
        .containter a{text-decoration:none;color:#333;}
        .containter a:hover{text-decoration:underline;color:#09F;}
        .footer{
            padding-top: 20px;
            border-top: 3px solid #c31114;
            width:1080px;
            height: 35px;
            margin:0 auto;
            background-color: white;
            border-bottom-left-radius: 10px;
			border-bottom-right-radius: 10px;
			clear: both;
           
            
        }
        #shopping {width:1080px;}
        #shopping table {
            width:100%;
            line-height:24px; 
            border-top:1px solid #666;
            border-bottom:1px solid #666;
           
        }
        #shopping table td{ 
        font-weight:normal;
            padding:10px 0;
            border-top:1px solid #666; }
            
        #shopping table th{ 
        font-weight:normal;
            padding:10px 0;}
        .thumb img { margin:0 10px; vertical-align:middle; }
        
        .price,.number,.delete{ text-align:center; width:150px; border-left:1px dotted  #666;}
        .delete a{text-decoration: none;color: #666;}
        .number input { width:23px; height: 23px; border:0; text-align:center;} 
        #shopping .button{
            background:white;
            height:30px;
            margin-top:10px;
        }
        #shopping .button input{
            padding:8px; 
            background:#c31114;
            color:white;
            height:30px;
            width:150px;
            display:none;
            border:none;
            float:right;
            }
         .delete .button{
            background:white;
            height:30px;
            margin-top:10px;
        }
         .delete .button input{
            padding:8px; 
            background:#c31114;
            color:white;
            height:15px;
            width:20px;
            display:none;
            border:none;
            float:right;
            }   
        
          #register { clear:both;
            padding:20px;
            height:400px;}
          #register .shadow { width:599px; margin:0 auto; border-color: #999999;background-color: white;}
          #register form { clear:both; ;margin:0px auto }
          #register form table { width:100%; }
          #register form table td { padding:10px 0; }
          #register form table td.field { width:220px; text-align:right; font-size:14px; }
          #register form table td input.text { border-left:1px solid #686868; border-top:1px solid #686868; border-bottom:1px solid #b6b6b6; border-right:1px solid #b6b6b6; padding:3px 4px; width:200px; }

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
				   <li class="nav-item"><a href="usercenter.jsp">个人中心</a></li>
					
				</ul>
			</div>
		
		</div>
		<div class="banner">
            <div id="register">
	<div class="shadow">
		
		<div class="box">
			<form method="post" action="UpdateUserServlet" >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td>${name.username}</td>
					</tr>
					
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="password" name="password" />&nbsp;*</td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" name="rePassword"  />&nbsp;*</td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" value="T" checked="checked"/>男 <input type="radio" name="sex" value="F"/>女</td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" value="${name.useremail}" /></td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="phone" value="${name.userphone}" /></td>
					</tr>
					<tr>
						<td class="field">收货地址：</td>
						<td><input type="text" class="text" name="address" value="${name.useradress}"/></td>
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