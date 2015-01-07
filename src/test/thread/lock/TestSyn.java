package test.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


public class TestSyn implements Runnable {
	private Lock lock;
	private TestNum testNum;
	
	public TestSyn(TestNum testNum, Lock lock){
		this.testNum=testNum;
		this.lock=lock;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				if(lock.tryLock(50, TimeUnit.MILLISECONDS)){
					//必须要加，防止异常后锁没有释放
					try{
						testNum.setNum(testNum.getNum()+1);
						System.out.println(Thread.currentThread().getName()+"--"+testNum.getNum());
					}finally{
						lock.unlock();
						break;
					}
				}else {
					System.out.println(Thread.currentThread().getName()+" has no lock!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" get lock fail!");
			}
		}
	}
}
