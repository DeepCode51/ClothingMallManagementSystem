package ShopServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Category;
import Bean.Product;
import Bean.User;
import BeanDao.CategoryDao;
import BeanDao.ProductDao;


public class SelectProImgServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectProImgServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*商品详情*/
		ArrayList<Category> flist = CategoryDao.selectCatebigid();
		request.setAttribute("flist", flist);
		
		ArrayList<Category> clist = CategoryDao.selectCatechildid();
		request.setAttribute("clist", clist);
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		User username=(User)session.getAttribute("name");
		if(username!=null){
		String proid = request.getParameter("proid");
		Product pro = null;
     	if(proid!=null){
			pro = ProductDao.selectByPComment(Integer.parseInt(proid));
			if(pro==null){
				Product pro1 = ProductDao.selectById(Integer.parseInt(proid));
				request.setAttribute("pro", pro1);
				request.setAttribute("pro.codetail", null);
				request.getRequestDispatcher("proimg.jsp").forward(request, response);
			}
			else{
				request.setAttribute("pro", pro);
				request.getRequestDispatcher("proimg.jsp").forward(request, response);
				
			}
			
		}
		
		}
		else{
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('请先登录');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
