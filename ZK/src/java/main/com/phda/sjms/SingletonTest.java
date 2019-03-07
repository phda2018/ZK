package com.phda.sjms;

public class SingletonTest extends Thread{
	
	@Override
	public void run() {
		Dog dog = Dog.getInit();
//		System.out.println("对象:"+dog+" 线程对象:"+this);
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<20;i++) {
			SingletonTest st = new SingletonTest();
			st.start();
		}
	}
}


class Dog{
	private static Dog dog = null;
	static {
		System.out.println("创建dog");
		dog = new Dog();
	}
	private Dog() {
	}
	public static Dog getInit() {
		return dog;
	}
	
	/*public synchronized static Dog getInit() {
		if(dog == null)
			dog = new Dog();
		return dog;
	}*/
	
}



