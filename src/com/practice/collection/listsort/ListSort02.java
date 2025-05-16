package com.practice.collection.listsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//使用匿名內部類
public class ListSort02 {
	public static void main(String[] args) {

		Person p1 = new Person("a", 20);
		Person p2 = new Person("ab", 19);
		Person p3 = new Person("dd", 18);
		Person p4 = new Person("eee", 17);
		Person p5 = new Person("wwe", 16);

		List<Person> persons = new ArrayList<>();

		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);

		// 排序，new一個比較器接口 (interface Comparator)
		//直接在裡面寫，就不用再寫一個class
		persons.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
//		lambda寫法
//		persons.sort((o1, o2) ->  o1.getAge() - o2.getAge());
		
		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}

	}
}
