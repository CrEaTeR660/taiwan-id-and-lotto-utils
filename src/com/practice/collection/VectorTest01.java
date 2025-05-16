package com.practice.collection;

import java.util.List;
import java.util.Vector;

public class VectorTest01 {
public static void main(String[] args) {
	
	List<String> list = new Vector<>();
	//看怎麼擴容? 因為現成安全擴容為2倍
	//線程安全，被synchronized修飾
	list.add("1");
	list.add("2");
	list.add("3");
	list.add("4");
	list.add("5");

	
	
	
	
}
}
