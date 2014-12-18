package web.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import web.view.bean.UserInfo;

public class UserInfoHttpMessageConverter extends AbstractHttpMessageConverter<UserInfo> {
	
	public UserInfoHttpMessageConverter(){
		super(new MediaType("application","json"));
	}
	
	@Override
	protected boolean supports(Class<?> type) {
		return type==UserInfo.class;
	}

	@Override
	protected UserInfo readInternal(Class<? extends UserInfo> type,
			HttpInputMessage httpinputmessage) throws IOException,
			HttpMessageNotReadableException {
		if(type!=UserInfo.class){
			throw new IOException("类型错误");
		}
		String str= FileCopyUtils.copyToString(new InputStreamReader(httpinputmessage.getBody(), "utf-8"));
		String[] params=str.split(",");
		UserInfo userInfo=new UserInfo();
		userInfo.setId(Integer.parseInt(params[0]));
		userInfo.setName(params[1]);
		userInfo.setBirthdayDate(new Date());
		return userInfo;
	}

	@Override
	protected void writeInternal(UserInfo userInfo, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		outputMessage.getHeaders().setContentType(new MediaType("application","json"));
		OutputStream outputStream= outputMessage.getBody();
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
		writer.write(userInfo.getId()+":"+userInfo.getName()+":"+userInfo.getBirthdayDate());
		writer.flush();
	}

}
