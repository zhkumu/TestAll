package test.jdk.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestA implements Serializable {
	private TestB testB;
	
	public TestA(TestB testB){
		this.testB=testB;
	}
	
	@Override
	public String toString() {
		return testB.toString();
	}

	protected Object copy() throws Exception {
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(outputStream);
		out.writeObject(this);
		out.flush();
		ObjectInputStream input=new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
		Object object= input.readObject();
		out.close();
		input.close();
		return object;
	}
}
