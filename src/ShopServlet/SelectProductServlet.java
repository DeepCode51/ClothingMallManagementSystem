package ShopServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Car;
import Bean.Category;
import Bean.Product;
import Bean.User;
import BeanDao.CarDao;
import BeanDao.CategoryDao;
import BeanDao.ProductDao;
import BeanDao.Tools;


public class SelectProductServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectProductServlet() {
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
		ArrayList<Category> flist = CategoryDao.selectCatebigid();
		request.setAttribute("flist", flist);
		ArrayList<Category> clist = CategoryDao.selectCatechildid();
		request.setAttribute("clist", clist);
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		User username=(User)session.getAttribute("name");
		if(username!=null){
		String selectname =Tools.codeToChiese(request.getParameter("selectname"));
		int cpage = 1;
		int count = 8;
		String cp= request.getParameter("cp");
		if(cp!=null){
			cpage = Integer.parseInt(cp);
		}
		int tpage = 0;
		String catebigid= request.getParameter("catebigid");
		String catechildid = request.getParameter("catechildid");
		
		ArrayList<Product> list = null;
	    if(catebigid==null&&catechildid==null&&selectname==""){
		    list = ProductDao.selectAll(cpage, count);
			request.setAttribute("title", "全部商品");
		    tpage = ProductDao.totalPage(count);
		}
		
		if(catebigid!=null){
			int id = Integer.parseInt(catebigid);
			list = ProductDao.selectAllByBigid(cpage, count, id);
			tpage = ProductDao.totalPageByBigid(count, id);
			request.setAttribute("title",CategoryDao.selectById(id).getCatename());
		}
		if(catechildid!=null){
			int id = Integer.parseInt(catechildid);
			list = ProductDao.selectAllByCid(cpage, count, id);
			tpage = ProductDao.totalPageByCid(count, id);
			request.setAttribute("title", CategoryDao.selectById(id).getCatename());
			
		}
		if(selectname!=""){
			list=ProductDao.selectAllByName(cpage,count,selectname);
			tpage = ProductDao.totalPageByName(count, selectname);
			request.setAttribute("title", "查询结果");
			
		}
	
		request.setAttribute("list", list);
		request.setAttribute("cpage", cpage);
		request.setAttribute("tpage", tpage);
		request.setAttribute("search_words", selectname);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
		}else{
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
