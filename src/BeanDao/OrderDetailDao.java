package BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Order;
import Bean.OrderDetail;

public class OrderDetailDao {
	/*搜索订单详情*/
	public static ArrayList<OrderDetail> selectById(String username){
		ArrayList<OrderDetail> dd=new ArrayList<OrderDetail>();
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select*from userorder,ordertable,product where userorder.Username=? and userorder.oid=ordertable.oid and ordertable.proid=product.proid;");
			ps.setString(1,username);
			rs=ps.executeQuery();
			while (rs.next()) {
				OrderDetail o=new OrderDetail(rs.getInt("oid"),rs.getInt("otid"),rs.getString("Username"),rs.getString("proname"), rs.getString("propname"), rs.getInt("proprice"), rs.getInt("procount"), rs.getString("ostate"));
				dd.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeall(rs,ps,conn);
		}
		return dd;
	}
	/*订单签收*/
	public static int finshGoods(String otid){
		int num=0;
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=BaseDao.getconn();
			String sql="update ordertable set ostate=3 where otid=?;";
			pst=conn.prepareStatement(sql);
			pst.setString(1,otid);	
			num=pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			BaseDao.closeall(null, pst, conn);
		}
		return num;
		
	}
	/*管理员搜索订单详情*/
	public static ArrayList<OrderDetail> selectById(int oid){
		ArrayList<OrderDetail> dd=new ArrayList<OrderDetail>();
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select*from userorder,ordertable,product where userorder.oid=? and userorder.oid=ordertable.oid and ordertable.proid=product.proid;");
			ps.setInt(1, oid);
			rs=ps.executeQuery();
			while (rs.next()) {
				OrderDetail o=new OrderDetail(rs.getInt("oid"),rs.getInt("otid"),rs.getString("proname"), rs.getString("propname"), rs.getInt("proprice"), rs.getInt("procount"), rs.getString("ostate"));
				dd.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeall(rs, ps, conn);
		}
		return dd;
	}
	/*订单发货*/
	public static int finshGoodsOne(String otid){
		int num=0;
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=BaseDao.getconn();
			String sql="update ordertable set ostate=2 where otid=?;";
			pst=conn.prepareStatement(sql);
			pst.setString(1,otid);	
			num=pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			BaseDao.closeall(null, pst, conn);
		}
		return num;
		
	}
	/*查看单个订单*/
	public static OrderDetail selectdetailById(int otid){
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		OrderDetail o=null;
		try {
			ps=conn.prepareStatement("select*from ordertable,product where ordertable.otid=? and ordertable.proid=product.proid;");
			ps.setInt(1, otid);
			rs=ps.executeQuery();
			while (rs.next()) {
				o=new OrderDetail(rs.getInt("otid"),rs.getString("proname"), rs.getString("propname"), rs.getInt("proprice"), rs.getInt("procount"), rs.getString("ostate"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeall(rs, ps, conn);
		}
		return o;
	}
	/*订单评价*/
	public static int finshComments(String otid){
		int num=0;
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=BaseDao.getconn();
			String sql="update ordertable set ostate=4 where otid=?;";
			pst=conn.prepareStatement(sql);
			pst.setString(1,otid);	
			num=pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			BaseDao.closeall(null, pst, conn);
		}
		return num;
		
	}
	
	
	

}
