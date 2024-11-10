<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/loginstyle.css">
    <script type="text/javascript" src="scripts/function.js"></script>
	<style type="text/css">
	
	#login{
	       
            background:url("images/login.jpg") no-repeat;
            background-size:cover;
            padding:100px;
            height:500px;
        }
        #na1{
            background:url("images/icon-user.png") 5px 5px no-repeat;
            background-size: 30px;
            text-indent:50px;
            font-size: 18px;
        }
        #password{
            background:url("images/mima.png") 5px 5px no-repeat;
            background-size:30px;
            text-indent:50px;
        }
         h2{
            font-size:20px;  
            line-height:54px; 
            color:#4c4d4b; 
            padding-left:px;
            border-bottom:solid #E85F61 3px;
            
          
        }
        .sub1{
            position: relative;
            top:-20px;
            left: 24px;
            width: 300px;
            height:40px;
        }
	</style>
</head>

<body>
	<div id="login">
            <div class="loginer">
                <h1>账号登录</h1>
                <form  method="post" action="LoginServlet" >
                    <table>
                            <tr>
						        <td><input class="text" type="text" name="username" id="na1"></td>
					        </tr>
					         <tr>
                                 <td><input class="text" type="password" id="password" name="password" ></td>
					         </tr>
                            
					<tr>
						<td>
                            <label class="subbox">
                                <input type="submit" name="submit" id="sub" value="登录" >
                            </label>
                        </td>
					</tr>
					
					

				</table>
				
			</form>
			<form  action="index.jsp" >
                <input type="submit" name="submit1" class="sub1" value="返回首页">
            </form>
			
		
	</div>
         
   </div>
        
       
    
    </body>
</html>