package com.practice.collection.arrysort;

public class User implements Comparable <User>{

	private String name;
	private int age;
	
	public User() {
		super();
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	//關於compareTo方法返回值
	/*
	 * 如果回傳0就是相等，回傳大於0，a>b 
	 * a-b == 0 a==b
	 * a-b > 0  a>b
	 * a-b < 0 a<b
	 */
	@Override
	public int compareTo(User user) {
		//這裡提供比較規則
		
//		return this.age - user.age;(升續)
		//物件會跟每一個物件比較，都比較過(冒泡排序)
		//this放後就會變成降續排序
		
		return this.name.compareTo(user.name);
		//名字要用compareTo(String)
		
		
	}
	
	
	
	
}
