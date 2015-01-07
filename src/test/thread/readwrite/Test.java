package test.thread.readwrite;

public class Test {

	public static void main(String[] args) {
		TestNum testNum=new TestNum(1);
		for (int i = 0; i < 10; i++) {
			new Thread(new TestSyn(testNum)).start();
		}
	}

}
