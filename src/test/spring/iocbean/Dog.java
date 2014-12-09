package test.spring.iocbean;

public class Dog {
	private int id;
	private String name;
	private String remark;
	public int getId() {
		return id;
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
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	
}
