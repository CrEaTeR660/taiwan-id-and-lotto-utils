package com.practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	public static void main(String[] args) {

		List<String> names = new ArrayList();

		names.add("湯姆");
		names.add("捷克");
		names.add("lisi");

		
		//用listIterator
		ListIterator<String> li = names.listIterator();
		while(li.hasNext()) {
			String name = li.next();
			if("lisi".equals(name)) {
				li.add("李四");
			}
//			System.out.println(name);
		}
		System.out.println(names);

	}
}
