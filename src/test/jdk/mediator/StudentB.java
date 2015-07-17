package test.jdk.mediator;

public class StudentB {
	private Mediator mediator;
	public StudentB(Mediator mediator){
		this.mediator=mediator;
	}
	public void run(){
		System.out.println("B run");
		mediator.bgo();
	}
	
	public void go(){
		System.out.println("B go");
	}
}
