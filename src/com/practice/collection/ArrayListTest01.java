package com.practice.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest01 {
	public static void main(String[] args) {
		List list = new ArrayList();

		list.add("lisi");
		list.add("lisi");
		list.add("lisi");
		list.add("lisi");
		list.add("lisi");
		list.add("lisi");
		
		//修改某個元素
		String oldData = (String) list.set(1, "lisi2");
		System.out.println(oldData);
		//為啥回傳舊址
		//是因為透過舊址再把新址的值丟過去(這API設計原理)
		//對於中間的話，增刪效率低，增加會再把，每個元素往後移(或前) 時間複雜度是O(n)
		//關係於大量元素位移，跟拷貝問題(底層實際運作)
		//如果是頭尾就沒差，因為時間複雜度O(1);
		//搜尋效率高因為有index，可以根據第一個索引值找到後續索引直，地址是連續的
		
		//插入元素
		list.add(0,"張三");
		System.out.println(list);
		
	}
}
