package test.mybatis.one.bean;

import org.apache.ibatis.type.Alias;

@Alias("headImg")
public class HeadImg {
	private int id;
	private byte[] img;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}

}
