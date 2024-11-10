package BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Comment;
import Bean.Product;
import Bean.User;


public class CommentDao {
	
	/*用户评价*/
	public static ArrayList<Comment> selectCommentByName(String name){
		ArrayList<Comment> list = new ArrayList<Comment>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement("select coid,comment.otid,proname,propname,codetail,Username from comment,product,ordertable,user where Username=? and user.Userid=comment.Userid and comment.otid=ordertable.otid and ordertable.proid=product.proid;");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment co = new Comment(rs.getInt("coid"),
						rs.getInt("otid"), 
						rs.getString("proname"),
						rs.getString("propname"),
						rs.getString("codetail"));
				list.add(co);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	/*商品评价*/
	public static ArrayList<Comment> selectCommentById(int id){
		ArrayList<Comment> list = new ArrayList<Comment>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement("select coid,comment.otid,proname,propname,codetail,Username from comment,product,ordertable,user where comment.otid=? and user.Userid=comment.Userid and comment.otid=ordertable.otid and ordertable.proid=product.proid;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment co = new Comment(rs.getInt("coid"),
						rs.getInt("otid"), 
						rs.getString("proname"),
						rs.getString("propname"),
						rs.getString("codetail"));
				list.add(co);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	/*新增评论*/
	public static int insert(Comment co){
		String sql = "insert into comment values(null,?,?,?)";
		Object[] params = {co.getOtid(),co.getCodetail(),co.getUserid()};
		return BaseDao.exectuIUD(sql, params);
	}
	/*分页*/ 
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from comment");
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
	/*管理员查找评价信息*/ 
	public static ArrayList<Comment> selectAll(int cpage,int count){
		ArrayList<Comment> list = new ArrayList<Comment>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement("select coid,comment.otid,proname,propname,codetail,Username from comment,product,ordertable,user where user.Userid=comment.Userid and comment.otid=ordertable.otid and ordertable.proid=product.proid limit ?,?;");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment co = new Comment(rs.getInt("coid"),
						rs.getInt("otid"), 
						rs.getString("proname"),
						rs.getString("propname"),
						rs.getString("codetail"),
						rs.getString("Username"));
				list.add(co);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	/*删除评论*/
	public static int deleteComment(int coid){
		String sql = "delete from comment where coid=?";
		Object[] params = {coid};
		return BaseDao.exectuIUD(sql, params);
	}

}
