package test.thread.readwrite;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestNum {
	private ReadWriteLock lock=new ReentrantReadWriteLock();
	private Lock readLock=lock.readLock();
	private Lock writeLock=lock.writeLock();
	private int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public TestNum(int num){
		this.num=num;
	}

	public void action(){
		while (true) {
			try {
				if(writeLock.tryLock(1, TimeUnit.SECONDS)){
					try{
						System.out.println(Thread.currentThread().getName()+"--"+(num++));
					}finally{
						writeLock.unlock();
						break;
					}
					
				}else {
					System.out.println(Thread.currentThread().getName()+" has no lock!");
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
