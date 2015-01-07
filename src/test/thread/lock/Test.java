package test.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestNum testNum=new TestNum(1);
		Lock lock=new ReentrantLock();
		for (int i = 0; i < 10; i++) {
			new Thread(new TestSyn(testNum,lock)).start();
		}
	}

}
