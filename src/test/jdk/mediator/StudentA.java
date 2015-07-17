package test.jdk.mediator;

public class StudentA {
	private Mediator mediator;
	public StudentA(Mediator mediator){
		this.mediator=mediator;
	}
	public void go(){
		System.out.println("B run");
		mediator.ago();
	}
	
	public void run(){
		System.out.println("A run");
	}
}
