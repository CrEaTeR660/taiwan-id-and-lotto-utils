package com.practice.collection.listsort;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		//實現方法去制定比較規則
		return o1.getName().compareTo(o2.getName());
	}

}
