package test.freemarker.ftl;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void main(String[] args) throws IOException, TemplateException {
		Configuration configuration=new Configuration();
		configuration.setClassForTemplateLoading(Test.class, "template");
		Template template= configuration.getTemplate("mu.ftl");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "mu");
		map.put("age", 30);
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		map.put("list", list);
		
		Map<String, String> dataMap=new HashMap<String, String>();
		dataMap.put("d1", "t1");
		dataMap.put("d2", "t2");
		map.put("map", dataMap);
		
		Writer writer=new OutputStreamWriter(System.out);
		template.process(map, writer);
		writer.flush();
		writer.close();
	}

}
