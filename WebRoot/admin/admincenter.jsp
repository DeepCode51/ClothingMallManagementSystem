<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-个人订单</title>
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
			height: 450px;
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
	</style>

</head>

<body>
	<div id="suber">
		<div class="top clearfix">
		    <ul id="leftlink">
				<li><c:if test="${name==null}"><a href="../login.jsp">登录&nbsp;&nbsp;&nbsp;</a></c:if></li>
				<li><c:if test="${name!=null}">当前用户&nbsp;${name.username}</c:if></li>
			</ul>
			<ul id="rightlink">
				<li><a href="admincenter.jsp" id="a3">个人中心</a></li>
		        <li><a href="../OutServlet" id="a4">退出</a></li>
			</ul>
		
		</div>
		<div class="header clearfix">
			<div class="header-top clearfix">
				<div class="logo fl">
					<img src="../images/logo.jpg" alt="">
				</div>
				<div class="info fr">
					
				  <div class="fr">
						
					</div>
				</div>
			</div>
			<div class="header-nav">
				<ul>
					<li class="nav-item"><a href="../Mindex.jsp">首页</a></li>
					<li class="nav-item"><a href="../UserShowServlet">用户管理</a></li>
					<li class="nav-item"><a href="../ProductShowServlet">商品管理</a></li>
					<li class="nav-item"><a href="../OrderShowServlet">订单管理</a></li>
				</ul>
			</div>
		
		</div>
		<div class="banner">
            <div id="shopping">
                   <table>
                       <tr><th>用户ID</th><th>用户名</th><th>性别</th><th>手机</th><th>收货地址</th><th>邮箱</th><th>操作</th></tr>
                       
					    <tr align="center"> 
						  <td>${name.userid}</td>
						  <td>${name.username}</td>
						  <td>${name.usersex=='T'?'男':'女'}</td>
						  <td>${name.userphone}</td>
						  <td>${name.useradress}</td>
						  <td>${name.useremail}</td>
						  <td class="delete"><a href="updateadmin.jsp">修改</a></td>
					    </tr>
					 
				
			</table>
			
		
	</div>
	</div>
	</div>
        <div class="footer">
            <p align="center">宝舒儿童服饰购物网站</p>
        </div>
    
</body>
</html>