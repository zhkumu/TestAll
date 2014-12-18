package web.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.ECField;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {

	//只能处理controller中的方法在执行过程中产生的异常
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj,
			Exception exception) {
		exception.printStackTrace();
		response.setHeader("Content-Type", "application/json");
		
		try {
			PrintWriter pr= response.getWriter();
			//当返回json格式结果时，需要做特殊处理，这里返回的任何结果都需要加字符串在外面，不然就不是json格式
			pr.write("1");
			pr.flush();
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//这里不能返回null，返回null会被springmvc继续处理
		return new ModelAndView();  
	}

}
