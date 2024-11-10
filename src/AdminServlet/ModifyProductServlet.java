package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import Bean.Category;
import Bean.Product;
import BeanDao.CategoryDao;
import BeanDao.ProductDao;

public class ModifyProductServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ModifyProductServlet() {
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
		request.setCharacterEncoding("gbk");
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		Files fs = su.getFiles();//获得所有文件
		File f = fs.getFile(0);//获得上传的文件
		String propname = f.getFileName();//获得文件名
		try {
			su.save("images/cloth");//保存图片到指定位置
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Request req1 = su.getRequest();
		String proid = req1.getParameter("proid");
		String proname = req1.getParameter("proname");
		String prodetail = req1.getParameter("prodetail");
		String proprice = req1.getParameter("proprice");
		String prostock = req1.getParameter("prostock");
		String cateid = req1.getParameter("cateid");
		String catebigid = req1.getParameter("catebigid");
		
		Product pro = null;
		if(proprice!=null&&prostock!=null&&cateid!=null){
			pro = new Product(Integer.parseInt(proid),proname, prodetail,Integer.parseInt(proprice),
					Integer.parseInt(prostock),Integer.parseInt(cateid),
					Integer.parseInt(catebigid),propname);
		}
		int count = 0;
		if(pro!=null){
			count = ProductDao.update(pro);
		}
		
		ArrayList<Category> flist = CategoryDao.selectCatebigid();
		request.setAttribute("flist", flist);
		ArrayList<Category> clist = CategoryDao.selectCatechildid();
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("ProductShowServlet").forward(request, response);

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
		request.setCharacterEncoding("GBK");
		SmartUpload su = new SmartUpload();
      	su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		Files fs = su.getFiles();//获得所有文件
		File f = fs.getFile(0);//获得上传的文件
		String propname = f.getFileName();//获得文件名
		try {
			su.save("images/cloth");//保存图片到指定位置
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Request req = su.getRequest();
		String proid = req.getParameter("proid");
		String proname = req.getParameter("proname");
		String prodetail =req.getParameter("prodetail");
		String proprice = req.getParameter("proprice");
		String prostock = req.getParameter("prostock");
		String cateid = req.getParameter("cateid");
		String catebigid = req.getParameter("catebigid");
		
		Product pro = null;
		if(proprice!=null&&prostock!=null&&cateid!=null){
			pro = new Product(Integer.parseInt(proid),proname, prodetail,Integer.parseInt(proprice),
					Integer.parseInt(prostock),Integer.parseInt(cateid),
					Integer.parseInt(catebigid),propname);
		}
		int counts = 0;
		if(pro!=null){
			counts = ProductDao.update(pro);
		}
		
		int cpage=1;
		int count=5;
		int tpage=ProductDao.totalPage(count);
		ArrayList<Product> list=ProductDao.selectAll(cpage,count);
		ArrayList<Category> clist = CategoryDao.selectCatechildid();
		request.setAttribute("clist", clist);
		request.setAttribute("productlist", list);
		request.setAttribute("cpage", cpage);
		request.setAttribute("tpage", tpage);
		ArrayList<Category> flist = CategoryDao.selectCatebigid();
		request.setAttribute("flist", flist);
		request.getRequestDispatcher("admin/product.jsp").forward(request, response);
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
