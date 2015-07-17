package test.jdk.builder;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Builder builder=new Builder1();
		Director director=new Director(builder);
		director.create();
	

	}

}
