package com.practice.collection.sequnencecollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.SequencedCollection;

/*
 *有序集合
 * SequnencedCollection
 * addFirst()
 * addLast()
 *removeFirst()
 *removeLast() 
 *getFirst()
 *getLast()
 *reversed()
 */
public class SequncedCollection {
	public static void main(String[] args) {

		SequencedCollection sc = new ArrayList();
		sc.add(1);
		sc.add(2);
		sc.add(3);
		sc.add(4);

//向頭部新增
		sc.addFirst(5);
		// 向尾部新增
		sc.addLast(6);

		// 使用迭帶器
		Iterator it = sc.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		// 刪除頭
		sc.removeFirst();
		// 刪除尾
		sc.removeLast();
		// 獲取頭
		System.out.println("獲取頭部" + sc.getFirst());
		// 獲取尾
		System.out.println("獲取尾部" + sc.getLast());

		it = sc.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}

		// 反轉
		SequencedCollection reverse = sc.reversed();
		System.out.println(reverse);
		
	}
}
