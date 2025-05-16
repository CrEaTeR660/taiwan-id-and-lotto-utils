package com.practice.calendar;

import java.util.Date;
//java.sql.Date是util的子包
public class DateTest01 {
	public static void main(String[] args) {
		
		//獲取系統當前時間，2025.....
		Date date = new Date();
		System.out.println(date);
		
		//獲取指定時間，在1970...加上一秒
		Date date1 = new Date(1000);//毫秒
		System.out.println(date1);
		
		//獲取當前系統前十分鐘，System.currentTimeMillis()1970到現在的總毫秒數
		Date date2 = new Date(System.currentTimeMillis()-1000*60*10);
		System.out.println(date2);
		
	}
}
