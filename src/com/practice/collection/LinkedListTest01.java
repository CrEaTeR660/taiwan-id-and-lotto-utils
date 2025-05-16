package com.practice.collection;

import java.util.LinkedList;

//LinkedList是雙向鍊表
//隨機增加或刪除的效率比較高o(1)
//因為沒有index所以查找效率比較低O(n)
//雙項鍊表[index1,data,index2],結構是(頭位置指向前一個數據的位置，尾巴位置是指向下一個數據的位置)，位址不連續 
//===============================
//單項鍊表，會存取下個地點的位址，雙向的話紹一個跟下一個都會存取;但是地址不是連續的
//環形單鍊表，最後一個為只存的是頭的地址
//環形雙練表，尾巴節點點指向頭節點的地址
public class LinkedListTest01 {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList();

		//往末尾加元素 
		ll.add("1");
		ll.add("2");
		ll.add("3");
		ll.add("4");
		ll.add("5");
		ll.add("6");
		ll.add("7");

		//修改，set方法返回的是改之前的舊值
		String oldData = ll.set(1, "3");
	
		System.out.println(oldData);
		System.out.println(ll);
		
		//返回的也是被刪除之前的值
		String oldData2 = ll.remove(1);
		System.out.println(oldData2);
		

	}
}
