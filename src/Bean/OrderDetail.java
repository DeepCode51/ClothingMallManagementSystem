package Bean;//我的订单详情
public class OrderDetail {
	private int otid;
	private int oid;
	private String Username;
	private String Useradress;
	private int proid;
	private String proname;
	private String propname;
	private int proprice;
	private int procount;
	private String ostate;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getOtid() {
		return otid;
	}
	public void setOtid(int otid) {
		this.otid = otid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getPropname() {
		return propname;
	}
	public void setPropname(String propname) {
		this.propname = propname;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}
	public int getProcount() {
		return procount;
	}
	public void setProcount(int procount) {
		this.procount = procount;
	}
	public String getOstate() {
		return ostate;
	}
	public void setOstate(String ostate) {
		this.ostate = ostate;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUsertadress() {
		return Useradress;
	}
	public void setUseradress(String useradress) {
		Useradress = useradress;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getUseradress() {
		return Useradress;
	}
	public OrderDetail(int aoid,int aotid, String aUsername,String aproname, String apropname,int aproprice, int aprocount, String aostate) {
		oid=aoid;
		otid=aotid;
		aUsername=Username;
		proname=aproname;
		propname=apropname;
		proprice=aproprice;
		procount=aprocount;
		ostate=aostate;	
	}
	public OrderDetail(int aoid,int aotid,String aproname, String apropname,int aproprice, int aprocount, String aostate) {
		oid=aoid;
		otid=aotid;
		proname=aproname;
		propname=apropname;
		proprice=aproprice;
		procount=aprocount;
		ostate=aostate;	
	}
	
     public OrderDetail(int aoid,int aproid, int aprocount,int aproprice,String aostate) {
		oid=aoid;
		proid=aproid;
		procount=aprocount;
		proprice=aproprice;
		ostate=aostate;	
	}
     public OrderDetail(int aotid,String aproname, String apropname,int aproprice, int aprocount, String aostate) {
 		otid=aotid;
 		proname=aproname;
 		propname=apropname;
 		proprice=aproprice;
 		procount=aprocount;
 		ostate=aostate;	
 	}
	

}
