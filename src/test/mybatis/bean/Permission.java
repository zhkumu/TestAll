package test.mybatis.bean;

import org.apache.ibatis.type.Alias;

@Alias("permission")
public class Permission {
	private int id;
	private String pName;
	private int rId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	
}
