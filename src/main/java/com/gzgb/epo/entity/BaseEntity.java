package com.gzgb.epo.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.hibernate.ObjectNotFoundException;

/**
 * 
 * <pre>
 * 基础entity Bean类，用于包装bean实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4793022675884814607L;
/*
	*//**
	 * 重写toString方法,在toString方法里面调用获取属性值的get方法
	 *//*
	public String toString() {
		String s = "";
		try {
			s = getPropertyString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	*//**
	 * 
	 * <pre>
	 * 获取对象所有属性名
	 * </pre>
	 * 
	 * @param entityName
	 * @return
	 * @throws Exception
	 *//*
	public String getPropertyString(Object entityName) throws Exception {
		Class c = entityName.getClass();
		Field field[] = c.getDeclaredFields();
		StringBuffer sb = new StringBuffer();

		sb.append("------ " + " begin ------\n");
		for (Field f : field) {
			sb.append(f.getName());
			sb.append(" : ");
			try {
				sb.append(invokeMethod(entityName, f.getName(), null));
			} catch (ObjectNotFoundException e) {
				sb.append(" can't find " + f.getName() + " object in database");
			} catch (Exception e) {

			}
			sb.append("\n");
		}
		sb.append("------ " + " end ------\n");
		return sb.toString();
	}

	*//**
	 * 
	 * <pre>
	 * 利用java反射来实现输出对象的所有属性值
	 * </pre>
	 * 
	 * @param owner
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Exception
	 *//*
	public Object invokeMethod(Object owner, String methodName, Object[] args)
			throws Exception {
		Class ownerClass = owner.getClass();

		methodName = methodName.substring(0, 1).toUpperCase()
				+ methodName.substring(1);
		Method method = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			return " can't find 'get" + methodName + "' method";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return method.invoke(owner);
	}*/

}
