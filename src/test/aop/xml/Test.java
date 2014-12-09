package test.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"test/aop/xml/aop.xml");
		ICodeService codeService = ctx.getBean("codeService",ICodeService.class);
		codeService.coding();
	}

}
