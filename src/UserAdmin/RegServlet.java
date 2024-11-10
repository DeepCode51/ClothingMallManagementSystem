package UserAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Category;
import Bean.User;
import BeanDao.CategoryDao;
import BeanDao.Tools;
import BeanDao.UserDao;


public class RegServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username=Tools.codeToChiese(request.getParameter("username"));
		String password=Tools.codeToChiese(request.getParameter("password"));
		String repassword=Tools.codeToChiese(request.getParameter("repassword"));
		String sex=Tools.codeToChiese(request.getParameter("sex"));
		String email=Tools.codeToChiese(request.getParameter("email"));
		String phone=Tools.codeToChiese(request.getParameter("phone"));
		String address=Tools.codeToChiese(request.getParameter("address"));
		PrintWriter out=response.getWriter();
		int count=0;
		if(repassword==password){
			if(username!=null&&sex!=null&&email!=null&&phone!=null&&address!=null){
				HttpSession session = request.getSession();
				User user=new User(username,repassword,sex,phone,address,email);
				count=UserDao.insert(user);
			}
			else{
				out.write("<script>");
				out.write("alert('*项必填');");
				out.write("location.href='reg.jsp'");
				out.write("</script>");
				out.close();
				
			}
		}
		else{
				out.write("<script>");
				out.write("alert('两次密码不同');");
				out.write("location.href='reg.jsp'");
				out.write("</script>");
				out.close();
			}
			
		 
			if(count>0){
				response.sendRedirect("re-result.jsp");
			}else{
				out.write("<script>");
				out.write("alert('注册失败');");
				out.write("location.href='reg.jsp'");
				out.write("</script>");
				out.close();
			}
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username=Tools.codeToChiese(request.getParameter("username"));
		String password=Tools.codeToChiese(request.getParameter("password"));
		String repassword=Tools.codeToChiese(request.getParameter("repassword"));
		String sex=Tools.codeToChiese(request.getParameter("sex"));
		String email=Tools.codeToChiese(request.getParameter("email"));
		String phone=Tools.codeToChiese(request.getParameter("phone"));
		String address=Tools.codeToChiese(request.getParameter("address"));
		PrintWriter out=response.getWriter();
		int count=0;
		int count1=UserDao.findByName(username);
		if(count1>0){
			out.write("<script>");
			out.write("alert('用户名已被使用');");
			out.write("location.href='reg.jsp'");
			out.write("</script>");
			out.close();
		}
		else{
	
		if(repassword.equals(password)){
			if(username!=""&&sex!=""&&email!=""&&phone!=""&&address!=""){
				HttpSession session = request.getSession();
				User user=new User(username,repassword,sex,phone,address,email);
				count=UserDao.insert(user);
			}
			else{
				out.write("<script>");
				out.write("alert('*项必填');");
				out.write("location.href='reg.jsp'");
				out.write("</script>");
				out.close();
				
			}
		}
		else{
				out.write("<script>");
				out.write("alert('两次密码不同');");
				out.write("location.href='reg.jsp'");
				out.write("</script>");
				out.close();
			}
		}
		
			
			
		 
			if(count>0){
				response.sendRedirect("re-result.jsp");
			}else{
				out.write("<script>");
				out.write("alert('注册失败');");
				out.write("location.href='reg.jsp'");
				out.write("</script>");
				out.close();
			}
		}
	
	
		
		
		
	

	
	public void init() throws ServletException {
		// Put your code here
	}

}
