package web.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.util.FileCopyUtils;

import web.view.bean.UserInfo;

public class UserInfoHttpMessageConverter extends AbstractHttpMessageConverter<UserInfo> {
	
	public UserInfoHttpMessageConverter(){
		//指定接受哪种content-type类型
		super(new MediaType("text","html"));
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
		//通过下面这种方式判断是否get或post请求，get的就可以从uri中获取到请求的参数
//		ServerHttpRequest request=(ServerHttpRequest)httpinputmessage;
//		System.out.println(request.getMethod());
//		System.out.println(request.getURI());
		
		//通过getBody获取post的请求参数
		String str= FileCopyUtils.copyToString(new InputStreamReader(httpinputmessage.getBody(), "utf-8"));
		str=URLDecoder.decode(str,"utf-8");
		String paramStr=str.substring(str.indexOf("=")+1);
		String[] params=paramStr.split(",");
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
