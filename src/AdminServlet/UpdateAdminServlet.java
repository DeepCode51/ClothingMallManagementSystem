package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.User;
import BeanDao.Tools;
import BeanDao.UserDao;


public class UpdateAdminServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateAdminServlet() {
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
		HttpSession session=request.getSession();
		User aa=(User)session.getAttribute("name");
		int userid=aa.getUserid();
		String username=aa.getUsername();
		int state=aa.getUserstate();

		String password=Tools.codeToChiese(request.getParameter("password"));
		String rePassWord=Tools.codeToChiese(request.getParameter("rePassword"));
		String sex=Tools.codeToChiese(request.getParameter("sex"));
		String email=Tools.codeToChiese(request.getParameter("email"));
		String phone=Tools.codeToChiese(request.getParameter("phone"));
		String address=Tools.codeToChiese(request.getParameter("address"));
		PrintWriter out=response.getWriter();
		int count=0;
		User user=null;
		
		if(rePassWord==password){
			if(sex!=null&&email!=null&&phone!=null&&address!=null&&sex!=""&&email!=""&&phone!=""&&address!=""){
				user=new User(userid,username,rePassWord,sex,phone,address,email,state);
				count=UserDao.update(user);
			}else{
				out.write("<script>");
				out.write("alert('*项必填');");
				out.write("location.href='updateuser.jsp'");
				out.write("</script>");
				out.close();
				
			}
			}else{
				out.write("<script>");
				out.write("alert('两次密码不同');");
				out.write("location.href='updateuser.jsp'");
				out.write("</script>");
				out.close();
				
			}
		
			if(count>0){
				session.setAttribute("name",user);
				out.write("<script>");
				out.write("alert('修改成功');");
				out.write("location.href='userorder.jsp'");
				out.write("</script>");
				out.close();
			}else{
				
				out.write("<script>");
				out.write("alert('修改失败');");
				out.write("location.href='updateuser.jsp'");
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
		HttpSession session=request.getSession();
		User aa=(User)session.getAttribute("name");
		int userid=aa.getUserid();
		String username=aa.getUsername();
		int state=aa.getUserstate();

		String password=Tools.codeToChiese(request.getParameter("password"));
		String rePassWord=Tools.codeToChiese(request.getParameter("rePassword"));
		String sex=Tools.codeToChiese(request.getParameter("sex"));
		String email=Tools.codeToChiese(request.getParameter("email"));
		String phone=Tools.codeToChiese(request.getParameter("phone"));
		String address=Tools.codeToChiese(request.getParameter("address"));
		PrintWriter out=response.getWriter();
		int count=0;
		User user=null;
		
		if(rePassWord.equals(password)){
			if(sex!=null&&email!=null&&phone!=null&&address!=null&&sex!=""&&email!=""&&phone!=""&&address!=""){
				user=new User(userid,username,rePassWord,sex,phone,address,email,state);
				count=UserDao.update(user);
			}else{
				out.write("<script>");
				out.write("alert('*项必填');");
				out.write("location.href='admin/updateadmin.jsp'");
				out.write("</script>");
				out.close();
				
			}
			}else{
				out.write("<script>");
				out.write("alert('两次密码不同');");
				out.write("location.href='admin/updateadmin.jsp'");
				out.write("</script>");
				out.close();
				
			}
		
			if(count>0){
				session.setAttribute("name",user);
				out.write("<script>");
				out.write("alert('修改成功');");
				out.write("location.href='admin/admincenter.jsp'");
				out.write("</script>");
				out.close();
			}else{
				
				out.write("<script>");
				out.write("alert('修改失败');");
				out.write("location.href='admin/updateuser.jsp'");
				out.write("</script>");
				out.close();
			}
	
	
			
	
		
		
		
		}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
