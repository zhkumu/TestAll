package test.spring.iocbean;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class MuInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues arg0,
			PropertyDescriptor[] arg1, Object arg2, String arg3)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

}
