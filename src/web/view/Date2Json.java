package web.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.jboss.weld.injection.spi.JpaInjectionServices;

public class Date2Json extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jg, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		jg.writeString(format.format(date));
		jg.flush();
		//这里不能调用jg的close方法，因为整个json的输出还未结束返回给客户端
	}

}
