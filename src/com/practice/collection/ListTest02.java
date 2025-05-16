package com.practice.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List
public class ListTest02 {
	public static void main(String[] args) {

		List<String> list = new ArrayList();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		// 底層一定會判斷下標有沒有越界
		// 在指定位置添加元素
		list.add(2, "張三");
		// 修改元素
		list.set(2, "李四");
		// 刪除元素
//		list.remove(2);

		// 獲取第一次的下標
		int index = list.indexOf("1");
		System.out.println("第一次出現的下標" + index);

		// 獲取最後一個元素的下標
		int lastIndex = list.lastIndexOf("3");
		System.out.println("最後一次下標的位置" + lastIndex);

		// 創建迭帶器
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("==============");
		// 獲取一個list集合
		List<String> newList = list.subList(3, 5); //[3,5]
		
		// 遍歷(對於list有特殊的便利方式)
		for (int i = 0; i < newList.size(); i++) {
			String s = newList.get(i);
			System.out.println(s);
		}
		
		//獲取一個不可以修改的集合，只讀的集合
		List<Integer> nums = List.of(1,1111,15,54456,4645,654);
		
		

	}
}
