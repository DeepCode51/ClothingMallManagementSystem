<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台-类目管理</title>
	<style type="text/css">
 *{
			margin: 0;
			padding: 0;
		}
		body{background-color:#f2f2f2f2;}
		#suber{
			width:1080px;
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
			color: #666;
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
            clean:both;
			
		}
		.lefterbox{
			width: 200px;
			height: 500px;
			float:left;
            background:#fafafa;
		}
		.firstbox{
			margin: 0 auto;
			width: 200px;
			
		}
		
		.lefterbox h2 {
			background:#c31114; 
			font-size:16px; 
			color:white;
			padding:5px 20px; 
		}
        .firstbox li { 
			font-weight:550; 
			padding:2px 20px; 
			margin-top: 15px;
			margin-bottom: 15px;
		}
       
        .firstbox li a{
			color:#666;
			text-decoration:none;
		} 
        .firstbox li a:hover{
			color:#c31114;
			text-decoration:none;
		} 
        .footer{
            padding-top: 20px;
            border-top: 3px solid #c31114;
            width:1080px;
            margin: 0 auto;
            height: 35px;
            background-color: white;
            border-bottom-left-radius: 10px;
			border-bottom-right-radius: 10px;
            clear: both;
    
      
        }
        .main{
            height: 500px;
            width: 880px;
            background-color:white;
            float:right;}
        .main h1{
            font-weight: normal;
			font-size:16px; 
			color:#666;
            padding-left: 30px;
			padding:5px 20px 0 20px ; }
        
         .main h1>a{
            font-weight: normal;
			font-size:16px; 
			color:#666;
            text-decoration: none;
        }
        .main h1>a:hover{
			color:#c31114;
			text-decoration:none;
		} 
        
        .pager { float:right;margin-top:30px; clear:both;}
        .pager ul { float:right; }
        .pager ul li { 
            float:left; 
            border:1px solid #eee; 
            line-height:18px;
            padding:0 3px;
            margin:0 1px;
            display:inline; }
        .pager ul li.current { font-weight:bold; color:#630; }
    
       
        #shopping {width:880px;}
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
        
        .delete a{text-decoration: none;color: #666;}
        .delete a:hover{text-decoration: none;color:#c31114;
        }    
        .adda{
            text-decoration: none;
            color: white;
            width: 80px;
            height:20px;
            background-color:#c4c6e4;
            padding:5px;
            line-height:20px;
            text-align: center;
            }
        a{text-decoration: none;}  
          
            
        
	</style>
	
</head>

<body>
	<div id="suber">
		<div class="top clearfix">
		    <ul id="leftlink">
				<li><c:if test="${name==null}"><a href="../login.jsp">登录 &nbsp;&nbsp;&nbsp;</a></c:if></li>
				<li><c:if test="${name!=null}">当前用户&nbsp;${name.username}</c:if></li>
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
					<li class="nav-item"><a href="UserShowServlet">用户管理</a></li>
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
				<li><a href="OrderShowServlet">查询销售额</a></li>
			</ul>
			<h2>商品管理</h2>
			<ul>
				<li><a href="ProductShowServlet">商品管理</a></li>
				<li><a href="CategoryShowServlet">类目管理</a></li>

			</ul>
			<h2>订单管理</h2>
			<ul>
				<li><a href="OrderShowServlet">订单处理</a></li>
                <li><a href="OrderShowServlet">查看评价</a></li>
			</ul>
			
		  </div>
          </div>
          <div class="main">
            <div id="shopping">
            <div class="adda"><a href="AddCateShowServlet" >新增</a></div>
                   <table>
                     <tr><th>类目ID</th><th>类目名称</th><th>所属类目ID</th><th>操作</th></tr>
                     <c:forEach var="cate" items="${catelist}">
					    <tr align="center"> 
						  <td>${cate.cateid}</td>
						  <td>${cate.catename}</td>
						  <td>
						  <c:if test="${cate.catebigid==0}">父类目</c:if>
						  <c:if test="${cate.catebigid>0}">
						    <c:forEach var="f" items="${flist}">
			                 <c:if test="${cate.catebigid==f.cateid}">
			                    ${f.catename}
			                 </c:if>
			                </c:forEach>
			              </c:if>
			              </td>
						  
						  <td class="delete"><a href="CateDetailShowServlet?cateid=${cate.cateid}">修改 &nbsp;&nbsp;<a href="DCateServlet?cateid=${cate.cateid}">删除</td>
					    
					    </tr>
					  </c:forEach>
				
			       </table>
			   <div class="pager">    
                   <ul class="clearfix">
			       <li>当前:${cpage}/${tpage}页</li>
                   <li><a href="CategoryShowServlet?cp=1">首页</a>
                   <li><a href="CategoryShowServlet?cp=${cpage-1<=0 ?1:cpage-1}">上一页</a></li>
                   <li><a href="CategoryShowServlet?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a></li>
                   <li><a href="CategoryShowServlet?cp=${tpage }">尾页</a></li>
                   <li>
			        <select onchange="jump(this.value)">
				       <c:forEach var="i" begin="1" end="${tpage}">
					    <option ${i==cpage ? "selected" : "" } value="${i}">${i }页</option>
				        </c:forEach>
		             </select>
                   </li>
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