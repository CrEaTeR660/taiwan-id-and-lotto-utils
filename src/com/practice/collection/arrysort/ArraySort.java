package com.practice.collection.arrysort;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {

		User u1 = new User("a", 20);
		User u2 = new User("ab", 19);
		User u3 = new User("dd", 18);
		User u4 = new User("eee", 17);
		User u5 = new User("wwe", 16);

		
		User[] users = {u1, u2,u3,u4,u5};
		//排序
		Arrays.sort(users);//java.lang.ClassCastException，
		//因為User沒有實現Comparable接口
		//沒有給User排序規則
		//怎麼讓User可以排序的，實現Comparable接口，並實現compareTo方法
		
		System.out.println(Arrays.toString(users));
	}
}
