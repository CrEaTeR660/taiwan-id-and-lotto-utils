package com.practice.collection.listsort;

import java.util.ArrayList;
import java.util.List;

import com.practice.collection.arrysort.User;

public class ListSort {
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

		// 排序(sort方法需要一個比較器)
		persons.sort(new PersonComparator());

		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}

	}
}