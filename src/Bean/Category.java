package Bean;

public class Category {
	private int cateid;
	private String catename;
	private int catebigid;
	
	
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public int getCatebigid() {
		return catebigid;
	}
	public void setCatebigid(int catebigid) {
		this.catebigid = catebigid;
	}
	public Category(int acateid, String acatename, int acatebigid){
		super();
		cateid=acateid;
		catename=acatename;
		catebigid=acatebigid;
	}
	public Category(int acateid, String acatename){
		super();
		cateid=acateid;
		catename=acatename;
	}
	public Category(String acatename, int acatebigid){
		super();
		catename=acatename;
		catebigid=acatebigid;
	}
}
