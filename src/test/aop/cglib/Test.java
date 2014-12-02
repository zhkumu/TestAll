package test.aop.cglib;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Monitor monitor=new Monitor();
		MyServiceImpl service= (MyServiceImpl)monitor.getProxy(MyServiceImpl.class);
		service.doSomething();
	}
}
