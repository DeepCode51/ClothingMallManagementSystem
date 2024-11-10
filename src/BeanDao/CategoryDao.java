package BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Bean.Category;
import Bean.OrderDetail;
import Bean.User;


public class CategoryDao {
	/*管理员查找类目信息*/ 
	public static ArrayList<Category> selectAll(int cpage,int count){
		ArrayList<Category> list = new ArrayList<Category>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement("select * from category order by catebigid,cateid limit ?, ? ");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()){
				Category cate = new Category(rs.getInt("cateid"),
						rs.getString("catename"), 
						rs.getInt("catebigid"));
				list.add(cate);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	/*分页*/ 
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from category");
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
	/*删除类目*/ 
	public static int deleteCategory(int cateid){
		String sql = "delete from category where cateid=?";
		Object[] params = {cateid};
		return BaseDao.exectuIUD(sql, params);
	}
	
	/*查找父类目*/ 
	public static ArrayList<Category> selectCatebigid(){
		ArrayList<Category> list = new ArrayList<Category>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from Category where catebigid= 0");
			rs = ps.executeQuery();
			while(rs.next()){
				Category cate= new Category(rs.getInt("cateid"),
										rs.getString("catename"),rs.getInt("catebigid"));
				list.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	/*查找子类目*/
	public static ArrayList<Category> selectCatechildid(){
		ArrayList<Category> list = new ArrayList<Category>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from Category where catebigid>0");
			rs = ps.executeQuery();
			while(rs.next()){
				Category cate= new Category(rs.getInt("cateid"),
										rs.getString("catename"),rs.getInt("catebigid"));
				list.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	/*查找类目*/
	public static Category selectById(int cateid){
		Category cate=null;
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select*from Category where cateid=?");
			ps.setInt(1, cateid);
			rs=ps.executeQuery();
			while (rs.next()) {
				cate= new Category(rs.getInt("cateid"),
						rs.getString("catename"),rs.getInt("catebigid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeall(rs, ps, conn);
		}
		return cate;
	}
	/*更新类目*/ 
	public static int updateCate(Category cate){
		String sql = "update category set catename=?,catebigid=? where cateid=?";
		Object[] params = {cate.getCatename(),cate.getCatebigid(),cate.getCateid()};
		return BaseDao.exectuIUD(sql, params);
	}
	
	/*新增类目*/ 
	public static int addCate(Category cate){ 
		String sql="insert into category(catename,catebigid) value(?,?)";
		Object[] params = { cate.getCatename(),cate.getCatebigid()};
		return BaseDao.exectuIUD(sql, params);
	}
	/*显示类目销售额*/
	public static double selectCateSale(int cateid){
		Connection conn=BaseDao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int sum=0;
		try {
			ps=conn.prepareStatement("select catename,sum(procount*ordertable.proprice)from ordertable,product,category where cateid=? and ordertable.proid=product.proid and product.catebigid=category.cateid;");
			ps.setInt(1,cateid);
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
