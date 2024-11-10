package BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import BeanDao.BaseDao;
import Bean.User;


public class UserDao {
	/*验证密码 */
	public static int selectByName(String name,String pword){
		int count=0;
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select count(*) from user where Username=? and Userpassword=?");
			ps.setString(1, name);
			ps.setString(2, pword);
			rs = ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs,ps,conn);
		}
		return count;
	}
	
	/* 判断是用户还是管理员*/
	public static User selectAdmin(String name,String pwd){
		User user=null;
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from user where Username=? and Userpassword=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("Userid"),rs.getString("Username"), rs.getString("Userpassword"),rs.getString("Usersex"),
						rs.getString("Userphone"),rs.getString("Useradress"),rs.getString("Useremail"),rs.getInt("Userstate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs,ps,conn);
		}
		return user;
	}
	/*注册用户*/
	public static int insert(User user){
		String sql="insert into user value(?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUserid(),
				            user.getUsername(),
							user.getUserpassword(),
							user.getUsersex(),
							user.getUserphone(),
							user.getUseradress(),
							user.getUseremail(),
							user.getUserstate()};
		return BaseDao.exectuIUD(sql, params);
	}
	/*更新用户信息*/ 
	public static int update(User user){
		String sql = "update user set Userpassword=?,Usersex=?,Userphone=?,Useradress=?,Useremail=?where Username=?";
		Object[] params = {user.getUserpassword(),
				user.getUsersex(),
				user.getUserphone(),
				user.getUseradress(),
				user.getUseremail(),
				user.getUsername()};
		return BaseDao.exectuIUD(sql, params);
	}
	/*分页*/ 
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from user");
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
	
	/*管理员查找用户信息*/ 
	public static ArrayList<User> selectAll(int cpage,int count){
		ArrayList<User> list = new ArrayList<User>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement("select * from user limit ?, ?");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("Userid"),rs.getString("Username"), rs.getString("Userpassword"),rs.getString("Usersex"),
						rs.getString("Userphone"),rs.getString("Useradress"),rs.getString("Useremail"),rs.getInt("Userstate"));
				list.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	public static int findByName(String name){
		int count=0;
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select count(*) from user where Username=? ");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs,ps,conn);
		}
		return count;
		
	}
	
	
	
	
}
