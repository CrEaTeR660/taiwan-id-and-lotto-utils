package com.practice.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List 有序可重複 (跟下標有關係)
//List以下的接口有
//ArrayList 數組 
//Vector 數組(線程安全
//LikedList 雙項鍊表
//因為list有繼承collection

public class ListTest01 {
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		
		
		System.out.println(numbers);
		
		//有順序，可以重複
		Iterator<Integer> it = numbers.iterator();
		while(it.hasNext()) {
			
		Integer num = it.next();
		System.out.println(num);
		
		
		}
	}
}
