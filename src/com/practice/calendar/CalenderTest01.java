package com.practice.calendar;

import java.util.Calendar;
//日歷
public class CalenderTest01 {
	public static void main(String[] args) {

		// 獲取當前時間的日曆對象(要調用靜態方法 Calendar.getInstance()
		Calendar calendar = Calendar.getInstance();
		// 不能透過new來創建對象，底層實現用getInstance
		System.out.println(calendar);

		// 獲取日曆中的年
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		//月份
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month);
		
		//獲取日曆中的日(今天是這個月的第幾天)
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
	}

}
