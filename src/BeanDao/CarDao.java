package BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Car;
import Bean.OrderDetail;
import Bean.User;


public class CarDao {
	/*查找购物车*/
	public static ArrayList<Car> getShop(int id){
		ArrayList<Car> list=new ArrayList<Car>();
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;  /*1 未结算 2已结算*/
			try {
				ps=conn.prepareStatement("select * from car,product where userid=? and buyend=1 and car.proname=product.proname order by carid;");
				ps.setInt(1,id);
				rs=ps.executeQuery();
				while(rs.next()){
					Car car=new Car(
							rs.getInt("carid"),
							rs.getString("propname"),
							rs.getString("proname"),
							rs.getInt("proprice"),
							rs.getInt("procount"),
							rs.getInt("prostock"),
							rs.getInt("proid"),
							rs.getInt("userid"),
							rs.getInt("buyend")
								);
					list.add(car);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeall(rs,ps,conn);
				
			}
			return list;
	}
	/*查找单个购物车*/
	public static Car getShopById(int carid){
		Car car=null;
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;  
			try {
				ps=conn.prepareStatement("select * from car,product where carid=? and buyend=1 and car.proname=product.proname order by carid;");
				ps.setInt(1,carid);
				rs=ps.executeQuery();
				while(rs.next()){
					 car=new Car(
							rs.getInt("carid"),
							rs.getString("propname"),
							rs.getString("proname"),
							rs.getInt("proprice"),
							rs.getInt("procount"),
							rs.getInt("prostock"),
							rs.getInt("proid"),
							rs.getInt("userid"),
							rs.getInt("buyend")
								);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeall(rs,ps,conn);
				
			}
			return car;
	}
	/*添加至购物车*/
	public static int insert(Car car){
		String sql="insert into car (propname,proname,proprice,procount,prostock,Userid,buyend)value(?,?,?,?,?,?,?)";
		Object[] params = {car.getPropname(),car.getProname(),car.getProprice(),car.getProcount(),car.getProstock(),car.getUserid(),car.getBuyend()};
		return BaseDao.exectuIUD(sql, params);
	}
	/*修改订单数 加*/
	public static int updateJia(int id){
		String sql="update car set procount=procount+1 where carid=?";
		Object [] params={id};
		return BaseDao.exectuIUD(sql, params);
	}
	/*修改订单数 减*/
	public static int updateJian(int id){
		String sql="update car set procount=procount-1 where carid=?";
		Object [] params={id};
		return BaseDao.exectuIUD(sql, params);
	}
	/*修改订单数 */
	public static int updateCount(int id,int count){
		String sql="update car set procount=? where carid=?";
		Object [] params={count,id};
		return BaseDao.exectuIUD(sql, params);
	}
	/*修改库存 */
	public static int updateStock(int count,int id){
		String sql="update Product set prostock=prostock-? where proid=?";
		Object [] params={count,id};
		return BaseDao.exectuIUD(sql, params);
	}
	/*添加至订单*/
	public static int insertUorder(int userid,String username,String useraddress,int oprice){
		String sql="insert into userorder values(null,?,?,?,now(),?)";
		Object [] params={userid,username,useraddress,oprice};
		return BaseDao.exectuIUD(sql, params);
	}
	/*查找最新订单号*/
	public static int getOid(){
		int id = 0;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select oid from userorder order by oid desc limit 0,1");
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return id;
	}
	/*添加订单详情*/
	public static int insertOd(OrderDetail od){
		String sql="insert into ordertable values(null,?,?,?,?,?)";
		Object [] params={od.getOid(),od.getProid(),od.getProcount(),od.getProprice(),od.getOstate()};
		return BaseDao.exectuIUD(sql, params);
	}
	/*修改购物车状态*/
	public static int updateBuyed(int id){
		String sql="update  car set buyend=2 where carid=?";
		Object [] params={id};
		return BaseDao.exectuIUD(sql, params);
	}
	/*删除购物车单项*/
	public static int deleteCproduct(int carid){
		String sql = "delete from car where carid=?";
		Object[] params = {carid};
		return BaseDao.exectuIUD(sql, params);
	}
	
}
