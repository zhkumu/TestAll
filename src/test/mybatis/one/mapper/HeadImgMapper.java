package test.mybatis.one.mapper;

import org.apache.ibatis.annotations.Param;

import test.mybatis.one.bean.HeadImg;

public interface HeadImgMapper {
	void addImg(@Param("img") byte[] img);
	
	HeadImg getImg();
}
