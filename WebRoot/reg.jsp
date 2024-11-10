<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>前台-注册</title>
    <script type="text/javascript" src="scripts/function.js"></script>
   
    <style type="text/css">
    .wrap { margin:0 auto; }
    #register { clear:both; background:url("images/login.jpg") no-repeat;
            background-size:cover;
            padding:100px;
            height:500px;}
    #register .shadow { width:599px; margin:0 auto; border-color: #999999;background-color: white;}
    #register .shadow h1 { font-size:24px; line-height:54px; color:#4c4d4b; padding-left:20px; border-bottom:solid #E85F61 3px; margin-bottom:1px; width: 250px;}  
    #register form { clear:both; padding:20px 0;margin:0px auto }
    #register form table { width:100%; }
    #register form table td { padding:10px 0; }
    #register form table td.field { width:220px; text-align:right; font-size:14px; }
    #register form table td input.text { border-left:1px solid #686868; border-top:1px solid #686868; border-bottom:1px solid #b6b6b6; border-right:1px solid #b6b6b6; padding:3px 4px; width:200px; }
    #register form label.ui-green { height:30px;}
         #register form label.ui-green input { font-size:18px; font-weight:bold; line-height:32px; height:30px; padding:0 15px; }
         #footer { clear:both; line-height:30px; text-align:center; margin-top:20px; background:#fafafa; color:#666; border-top:1px solid #e0e0e0; }

        .box h1 { 
            font-size:18px;  
            line-height:54px; 
            color:#4c4d4b; 
            padding-left:20px;
        
            
        }
    </style>
    </head>


<body>
    <div id="register">
	<div class="shadow">
		
		<div class="box">
			<h1>欢迎注册 宝舒会员~</h1>
			<form method="post" action="RegServlet" >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="username" value=""/>&nbsp;*</td>
					</tr>
					
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="password" name="password"  value=""/>&nbsp;*</td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" name="repassword" value=""/>&nbsp;*</td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" value="T" checked="checked"/>男 <input type="radio" name="sex" value="F"/>女</td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" value=""></td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="phone" value=""/></td>
					</tr>
					<tr>
						<td class="field">收货地址：</td>
						<td><input type="text" class="text" name="address" value="" /></td>
					</tr>
					
					
					
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" id="sub" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
