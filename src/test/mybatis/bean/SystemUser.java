package test.mybatis.bean;

import org.apache.ibatis.type.Alias;

@Alias("systemUser")
public class SystemUser {
	private int id;
	private String uName;
	private Role role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
