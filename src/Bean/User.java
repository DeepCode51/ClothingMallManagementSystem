package Bean;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class User {
	private int Userid;
	private String Username;
	private String Userpassword;
	private String Usersex;
	private String Useradress;
	private String Userphone;
	private String Useremail;
	private int Userstate;

	
	
	public int getUserid(){
		return this.Userid=Userid;
	}
	public void setUserid(int Userid){
		this.Userid=Userid;
	}
	public String getUsername(){
		return this.Username=Username;
	}
	public void setUsername(String Username){
		this.Username=Username;
	}
	public String getUserpassword(){
		return this.Userpassword=Userpassword;
	}
	public void setUserpassword(String Userpassword){
		this.Userpassword=Userpassword;
	}

	public String getUsersex(){
		return this.Usersex=Usersex;
	}
	public void setUsersex(String Usersex){
		this.Usersex=Usersex;
	}
	
	public String getUserphone(){
		return this.Userphone=Userphone;
	}
	public void setUserphone(String Userphone){
		this.Userphone=Userphone;
	}
	
	public String getUseradress(){
		return this.Useradress=Useradress;
	}
	public void setUseradress(String Useradress){
		this.Useradress=Useradress;
	}
	public int getUserstate(){
		return this.Userstate=Userstate;
	}
	
	public void setUserstate(int Userstate){
		this.Userstate=Userstate;
	}
	public String getUseremail(){
		return this.Useremail=Useremail;
	}
	
	public void setUseremail(String Useremail){
		this.Useremail=Useremail;
	}
	
	public User(String aUsername, String auserpass,
			String aUsersex,String aUserphone,String aUseradress,String aUseremail) {
		Username=aUsername;
		Userpassword=auserpass;
		Usersex=aUsersex;
		Useradress=aUseradress;
		Userphone=aUserphone;
		Useremail=aUseremail;
		
	}
	public User(int aUserid,String aUsername, String auserpass,
			String aUsersex,String aUserphone, String aUseradress,String aUseremail,
			int aUserstate) {
		Userid=aUserid;
		Username=aUsername;
		Userpassword=auserpass;
		Usersex=aUsersex;
		Useradress=aUseradress;
		Userphone=aUserphone;
		Useremail=aUseremail;
		Userstate=aUserstate;
		
	}
}