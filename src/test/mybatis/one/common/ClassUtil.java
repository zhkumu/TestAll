package test.mybatis.one.common;

import java.lang.reflect.Field;

public class ClassUtil {
	/**
	 * 获取属性
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	private static Field getField(Object obj,String fieldName){
		Class<?> cla=obj.getClass();
		Field field=null;
		try {
			field = cla.getDeclaredField(fieldName);
		} catch (Exception e) {
			
		} 
		return field;
	}
	
	/**
	 * 获取属性的值
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Object getFieldValue(Object obj,String fieldName){
		Object value=null;
		Field field=getField(obj, fieldName);
		if(!field.isAccessible()){
			field.setAccessible(true);
		}
		try {
			value= field.get(obj);
		} catch (Exception e) {
		} 
		return value;
	}
	
	/**
	 * 设置属性的值
	 * @param obj
	 * @param fieldName
	 * @param value
	 */
	public static void setFieldValue(Object obj,String fieldName,Object value){
		Field field=getField(obj, fieldName);
		if(!field.isAccessible()){
			field.setAccessible(true);
		}
		try {
			field.set(obj, value);
		} catch (Exception e) {
			
		} 
	}
}
