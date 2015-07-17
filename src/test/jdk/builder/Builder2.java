package test.jdk.builder;

public class Builder2 implements Builder {
	private Product product;
	@Override
	public void createProduct() {	
		product=new Product("product2");
	}
	
	public Product getResult(){
		return product;
	}
}
