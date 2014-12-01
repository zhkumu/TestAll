package test.spring.jdbc.bean;


import org.apache.ibatis.type.Alias;

@Alias("teacher")
public class Teacher {
	private int id;
	private String name;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", remark=" + remark
				+ "]";
	}
	
}
