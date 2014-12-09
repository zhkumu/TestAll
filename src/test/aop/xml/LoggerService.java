package test.aop.xml;

import java.util.Date;

public class LoggerService {
	public void logTime(){
		System.out.println(new Date());
	}
	
	public void logEvent(){
		System.out.println("event logger...");
	}
}
