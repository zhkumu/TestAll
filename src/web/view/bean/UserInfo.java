package web.view.bean;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import web.view.Date2Json;

public class UserInfo {
	private int id;
	
	private String name;
	
	//覆盖全局
	@JsonSerialize(using=Date2Json.class)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthdayDate;

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

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	
}
