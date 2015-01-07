package test.thread.syn;

public class TestSyn implements Runnable {
	private TestNum testNum;
	
	public TestSyn(TestNum testNum){
		this.testNum=testNum;
	}
	
	@Override
	public void run() {
		synchronized(testNum){
			testNum.setNum(testNum.getNum()+1);
			System.out.println(Thread.currentThread().getName()+"_"+ testNum.getNum());
		}
	}
}
