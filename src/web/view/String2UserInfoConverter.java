package web.view;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import web.view.bean.UserInfo;

public class String2UserInfoConverter implements Converter<String,UserInfo> {

	@Override
	public UserInfo convert(String str) {
		String[] params=str.split(",");
		UserInfo userInfo=new UserInfo();
		userInfo.setId(Integer.parseInt(params[0]));
		userInfo.setName(params[1]);
		userInfo.setBirthdayDate(new Date());
		return userInfo;
	}

}
