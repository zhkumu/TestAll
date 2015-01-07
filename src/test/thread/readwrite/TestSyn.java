package test.thread.readwrite;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestSyn implements Runnable {
	private TestNum testNum;
	
	public TestSyn(TestNum testNum){
		this.testNum=testNum;
	}
	
	@Override
	public void run() {
		testNum.action();
	}
}
