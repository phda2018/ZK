package com.phda.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 关于动态代理的 示例
 * @author phda
 *
 */
public class Proxy1<T> {

	/**
	 * jdk 动态代理
	 * 1.被代理对象一定有扩展的接口；
	 * 2.代理生成的对象类型，为被代理类的第一个扩展的接口类型==>t.class.getInerfaces() 数组中的第一个元素
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public T getObject(T t) {
		return (T)Proxy.newProxyInstance(t.getClass().getClassLoader(),//目标类的classLoader
				t.getClass().getInterfaces(), //目标类有实现的接口
                new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							System.out.println("可以定义一些其他业务操纵：日志操作");
							System.out.println("JDK代理实现:"+method.getName());//谁调用了某个方法，进行了什么操作
							return method.invoke(t, args);
					}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
//		Class[] t = teacher.getClass().getInterfaces();
//		System.out.println(t.length+" "+t[0].getName());
		Proxy1<Teacher> proxy = new Proxy1<Teacher>();
		Common teacherObj =(Common)proxy.getObject(teacher);
		teacherObj.Code("");;
		
		
	}

}
