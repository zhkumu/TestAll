package test.mybatis.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("role")
public class Role {
	private int id;
	private String rName;
	private List<Permission> permissions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Role(){
		permissions=new ArrayList<Permission>();
	}
}
