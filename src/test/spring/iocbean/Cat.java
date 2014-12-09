package test.spring.iocbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
	private int id;
	private String name;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Cat(){
		System.out.println("cat()");
	}
	
	public void init(){
		System.out.println("init");
	}
	
	public void catdestory(){
		System.out.println("catdestory");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println("setBeanName-------" +arg0 );
		
	}
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("setBeanFactory------"+arg0);
		
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destory");
		
	}
	
}
