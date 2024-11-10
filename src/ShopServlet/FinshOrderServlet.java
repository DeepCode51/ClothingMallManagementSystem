package ShopServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Car;
import Bean.OrderDetail;
import Bean.User;
import BeanDao.CarDao;
import BeanDao.Tools;

public class FinshOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FinshOrderServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Tools.encode(request);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("name");
		int userid=user.getUserid();
		String username=user.getUsername();
		String address=user.getUseradress();
		String carid=request.getParameter("carid");
		Car car=CarDao.getShopById(Integer.parseInt(carid));
		int proid=car.getProid();
		int procount=car.getProcount();
		int proprice=car.getProprice();
		int count5=CarDao.updateStock(procount,proid);
		int oprice=procount*proprice;
		int count=CarDao.insertUorder(userid,username,address,oprice);//加到userorder
		int oid=CarDao.getOid();//得到最新订单号
		OrderDetail od=new OrderDetail(oid,proid,procount,proprice,"1");
		int count2=CarDao.insertOd(od);
		int count3 =CarDao.updateBuyed(Integer.parseInt(carid));
		
		if(count>0){
				
			out.print("<script>");
			out.print("alert('购物成功');");
			out.print("location.href='ShopSelectServlet';");
			out.print("</script>");
			out.close();
		}else{
			out.print("<script>");
			out.print("alert('购物失败，请重新选择商品');");
			out.print("location.href='ShopSelectServlet';");
			out.print("</script>");
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
		PrintWriter out=response.getWriter();
		Tools.encode(request);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("name");
		int userid=user.getUserid();
		String username=user.getUsername();
		String address=user.getUseradress();
	    String oprice=request.getParameter("jstext");//总价钱
		String [] proid=request.getParameterValues("proid");//id
		String [] procount=request.getParameterValues("procount");//库存
		String [] proprice=request.getParameterValues("proprice");//单价
		
		//购买后对商品表的库存进行修改
		for(int i=0;i<proid.length;i++){
			int count5=CarDao.updateStock(Integer.parseInt(procount[i]),Integer.parseInt(proid[i]));
		}
		
		int count=CarDao.insertUorder(userid,username, address,Integer.parseInt(oprice));//加到userorder
		int oid=CarDao.getOid();//得到最新订单号
		//循环往订单详情添加
		for(int i=0;i<proid.length;i++){
			OrderDetail od=new OrderDetail(oid,Integer.parseInt(proid[i]),Integer.parseInt(procount[i]),Integer.parseInt(proprice[i]),"1");
			int count2=CarDao.insertOd(od);
		}
		String [] carid=request.getParameterValues("carid");
		for(int i=0;i<carid.length;i++){
			int count3 =CarDao.updateBuyed(Integer.parseInt(carid[i]));
		}
		if(count>0){
				
			out.print("<script>");
			out.print("alert('购物成功');");
			out.print("location.href='ShopSelectServlet';");
			out.print("</script>");
			out.close();
		}else{
			out.print("<script>");
			out.print("alert('购物失败，请重新选择商品');");
			out.print("location.href='ShopSelectServlet';");
			out.print("</script>");
			out.close();
		}
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
