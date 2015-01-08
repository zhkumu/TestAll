package test.jdk.builder;

import javax.ejb.CreateException;

public class Director {
	private Builder builder;
	
	public Director(Builder builder){
		this.builder=builder;
	}
	
	public void create(){
		builder.createProduct();
	}
}
