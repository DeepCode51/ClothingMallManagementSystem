package Bean;

public class Product{
	private int proid;
	private String proname;
	private String prodetail;
	private int proprice;
	private int prostock;
	private int cateid;
	private int catebigid;
	private String propname;
	private String codetail;
	
	public String getCodetail() {
		return codetail;
	}
	public void setCodetail(String codetail) {
		this.codetail = codetail;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProdetail() {
		return prodetail;
	}
	public void setProdetail(String prodetail) {
		this.prodetail = prodetail;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}
	public int getProstock() {
		return prostock;
	}
	public void setProstock(int prostock) {
		this.prostock = prostock;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getCatebigid() {
		return catebigid;
	}
	public void setCatebigid(int catebigid) {
		this.catebigid = catebigid;
	}
	public String getPropname() {
		return propname;
	}
	public void setPropname(String propname) {
		this.propname = propname;
	}
	public Product(int aproid, String aproname, String aprodetail,
    int aproprice, int aprostock, int acateid, int acatebigid,
	String apropname) {
		proid=aproid;
		proname=aproname;
		prodetail=aprodetail;
		proprice=aproprice;
		prostock=aprostock;
		cateid=acateid;
		catebigid=acatebigid;
		propname=apropname;
		
		
	}
	public Product(String aproname, String aprodetail,
		    int aproprice, int aprostock, int acateid, int acatebigid,
			String apropname) {
				proname=aproname;
				prodetail=aprodetail;
				proprice=aproprice;
				prostock=aprostock;
				cateid=acateid;
				catebigid=acatebigid;
				propname=apropname;
				
				
			}
	public Product(int aproid,String apropname) {
				proid=aproid;
				propname=apropname;
			}
	public Product(int aproid, String aproname, String aprodetail,
		    int aproprice, int aprostock, int acateid, int acatebigid,
			String apropname,String acodetail) {
				proid=aproid;
				proname=aproname;
				prodetail=aprodetail;
				proprice=aproprice;
				prostock=aprostock;
				cateid=acateid;
				catebigid=acatebigid;
				propname=apropname;
				codetail=acodetail;
				
			}
			
	

}
