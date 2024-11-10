package Bean;

public class Order {
	private int oid;
	private int Userid;
	private String Username;
	private String Useradress;
	private String odate;
	private int oprice;
	
	public String getUseradress() {
		return Useradress;
	}
	public void setUseradress(String useradress) {
		Useradress = useradress;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	
	public Order(int aoid, String aUsername,String aUseradress) {
		oid=aoid;
		Username=aUsername;
		Useradress=aUseradress;
	}
	public Order(int aoid, String aUsername,String aUseradress,int aoprice) {
		oid=aoid;
		Username=aUsername;
		Useradress=aUseradress;
		oprice=aoprice;
	}

}
