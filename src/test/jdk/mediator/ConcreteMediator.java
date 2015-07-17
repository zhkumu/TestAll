package test.jdk.mediator;

public class ConcreteMediator implements Mediator {
	
	private StudentA studentA;
	private StudentB studentB;
	
	public ConcreteMediator(StudentA studentA,StudentB studentB) {
		this.studentA=studentA;
		this.studentB=studentB;
	}

	@Override
	public void ago() {
	}

	@Override
	public void bgo() {
		
	}
}
