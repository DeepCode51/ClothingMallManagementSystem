package Bean;

public class Car {
	
	public int carid;
	public String propname; 
	public String proname; 
	public int proprice;
    public int procount;	
	public int prostock; 
	public int proid; 
	public int userid; 
	public int buyend; 
	
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getPropname() {
		return propname;
	}
	public void setPropname(String propname) {
		this.propname = propname;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
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
	public int getProstock() {
		return prostock;
	}
	public void setProstock(int prostock) {
		this.prostock = prostock;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBuyend() {
		return buyend;
	}
	public void setBuyend(int buyend) {
		this.buyend = buyend;
	}
	
	
	public Car(int acarid, String apropname, String aproname,
			int aproprice, int aprocount, int aprostock,int aproid,
			int auserid, int abuyend) {
		super();
		carid=acarid;
		propname=apropname;
		proname=aproname;
		proprice=aproprice;
		procount=aprocount;
		prostock =aprostock;
		proid=aproid;
		userid =auserid;
		buyend=abuyend;
	}
	public Car(String apropname, String aproname,
			int aproprice, int aprocount, int aprostock,
			int auserid, int abuyend) {
		super();
		
		propname=apropname;
		proname=aproname;
		proprice=aproprice;
		procount=aprocount;
		prostock =aprostock;
		userid =auserid;
		buyend=abuyend;
	}
	public Car(int acarid, int aprocount) {
		super();
		carid=acarid;
		procount=aprocount;
		
	}
}
	