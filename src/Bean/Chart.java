package Bean;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

import BeanDao.BaseDao;
import BeanDao.CategoryDao;
import Bean.Category;

public class Chart {
    public String cname;
	public int csum;
	
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCsum() {
		return csum;
	}


	public void setCsum(int csum) {
		this.csum = csum;
	}
 
	public Chart(String acname,int acsum){
		cname=acname;
		csum=acsum;
		
	}

	public static String generateBarChart(HttpSession session) throws IOException {

		/**
		 * 以下代码通过设置主题样式解決中文乱码问题
		 */
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN,25));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 20));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 20));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);

		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Chart> list = new ArrayList<Chart>();
		ResultSet rs = null;
		Connection conn = BaseDao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select catename,sum(procount*ordertable.proprice) as sumvalue from ordertable,product,category where ordertable.proid=product.proid and product.catebigid=category.cateid group by catename");
			rs = ps.executeQuery();
			while(rs.next()){
				dataset.addValue(rs.getInt("sumvalue"),"童装",rs.getString("catename"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		

		// 采用默认类别数据集采集数据
		
		 
		JFreeChart chart = ChartFactory.createBarChart3D("网站历史销量统计", 
		                  "",
		                  "总销量",
		                  dataset,
		                  PlotOrientation.VERTICAL,
		                  false,
		                  false,
		                  false);
		
		CategoryPlot plot = chart.getCategoryPlot();  
		//设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		//设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		//设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		
		 
		// 显示每个柱的数值，并修改数值的字体属性（renderer渲染器）
		BarRenderer3D renderer = new BarRenderer3D();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelFont(new Font("宋体",Font.PLAIN,15));
		

		renderer.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);
		
		// 设置平行柱之间的间距
		renderer.setItemMargin(0.4);
		//
		renderer.setMaximumBarWidth(0.15);
		// 将样式应用到CategoryPlot
		plot.setRenderer(renderer);
		
	

		

		// 使用ServletUtilities将工厂类生成的图表保存为png图片
		String fileName = ServletUtilities.saveChartAsPNG(chart, // 工厂类生成的图表
				700, // 要生成图片宽度
				500, // 要生成图片的高度
				session // HttpSession
		);

		// 返回图片的文件名
		return fileName;

	}

}
