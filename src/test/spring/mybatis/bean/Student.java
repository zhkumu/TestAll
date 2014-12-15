package test.spring.mybatis.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;


@Alias("student")
public class Student {
	private int id;
	private String name;
	private String remark;
	private Date birthday;
	private int color;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", remark=" + remark
				+ ", birthday=" + birthday + ", color=" + color + "]";
	}
}
