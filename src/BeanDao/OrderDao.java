package BeanDao;

import java.util.ArrayList;

import Bean.Order;
import Bean.OrderDetail;
import Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDao {
	
	/*分页*/ 
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from userorder");
			rs=ps.executeQuery();
			while(rs.next()){
				int sum=rs.getInt(1);
				if(sum%count==0){
					tpage=sum/count;
				}else{
					tpage=sum/count+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	
	/*管理员查找订单信息*/ 
	public static ArrayList<Order> selectAll(int cpage,int count){
		ArrayList<Order> list = new ArrayList<Order>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement("select * from userorder limit ?, ?");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()){
				Order order = new Order(rs.getInt("oid"),rs.getString("Username"), rs.getString("Useradress"));
				list.add(order);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	/*显示销售额信息*/ 
	public static int selectSale(String sdate,String edate){
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int sum=0;
		try {
			ps=conn.prepareStatement("select sum(oprice) from userorder where odatetime>=date_format(?,'%Y-%m-%d')and odatetime <=date_format(?,'%Y-%m-%d')");
			ps.setString(1,sdate);
			ps.setString(2,edate);
			rs=ps.executeQuery();
			while(rs.next()){
				sum=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeall(rs, ps, conn);
		}
		return sum;
	}


}
