package test.spring.iocbean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

public class Single {
	private Propertype propertype;

	public Propertype getPropertype() {
		return propertype;
	}

	
	public void setPropertype(Propertype propertype) {
		this.propertype = propertype;
	}

	@Override
	public String toString() {
		return "Single [propertype=" + propertype + "]";
	}

}
