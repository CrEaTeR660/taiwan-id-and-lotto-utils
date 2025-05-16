package com.practice.collection;
//自定義單項鍊

public class MyLink01<E> {

	// 元素個數
	private int size = 0;
	// 第一個節點
	private Node<E> first;

	// 構建空鍊表
	public MyLink01() {

	}

	// [data1, 1] [data2, 2]
	// 增加末尾
	public void add(E data) {
		// 如果first是空的話;表示是一個空練表
		if (first == null) {
			first = new Node<>(data, null);
		}
		// 找到末尾節點
		Node<E> last = findLast();

		last.next = new Node<>(data, null);

	}

	private Node<E> findLast() {

		if (first == null) {
			// 空練表
			return null;
		}
		// 程序到這肯定不是空練表
		// 假設第一個節點是最後一個節點
		Node<E> last = first;
		while (last.next != null) {
			last = last.next;
		}
		return last;
	}

	// 增加到指定位置，向某個位置添加據
	public void add(int index, E data) {

	}

	// 刪，刪除某個下標的數據
	public void remove(int index) {

	}

	// 改，修改指定索引的數據
	public void set(int index, E data) {

	}

	// 查 ，根據下標獲取的數據
	public E get(int index) {
		return null;

	}

	// 節點類，內部類(單項鍊表中的節點，建議靜態內部類)
	private static class Node<E> {

		// 數據
		E item;

		// 下一個節點的內存地址
		Node<E> next;

		// 構造下一個節點對象
		// 數據，下一個節點[data, next(地址)]
		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;

		}

	}
}
