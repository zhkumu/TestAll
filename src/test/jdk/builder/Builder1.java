package test.jdk.builder;

public class Builder1 implements Builder {
	private Product product;
	@Override
	public void createProduct() {
		product=new Product("product1");
	}
	
	public Product getResult(){
		return product;
	}
}
