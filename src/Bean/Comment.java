package Bean;

public class Comment {
	public int coid;
	public int otid;
	public String codetail;
	public int Userid;
	public String Username;
	public String proname;
	public String propname;
	
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
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public int getOtid() {
		return otid;
	}
	public void setOtid(int otid) {
		this.otid = otid;
	}
	public String getCodetail() {
		return codetail;
	}
	public void setCodetail(String codetail) {
		this.codetail = codetail;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Comment(int acoid,int aotid,String aproname,String apropname,String acodetail){
		coid=acoid;
		otid=aotid;
		codetail=acodetail;
		proname=aproname;
		propname=apropname;
		
	}
	public Comment(int aotid,String acodetail,int aUserid){
	
		otid=aotid;
		codetail=acodetail;
		Userid=aUserid;
		
	}
	public Comment(int acoid,int aotid,String aproname,String apropname,String acodetail,String aUsername){
		coid=acoid;
		otid=aotid;
		codetail=acodetail;
		proname=aproname;
		propname=apropname;
		Username=aUsername;
	}
	
	

}
