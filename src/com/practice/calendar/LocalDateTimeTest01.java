package com.practice.calendar;

import java.time.LocalDateTime;

public class LocalDateTimeTest01 {
	public static void main(String[] args) {
		//獲取當前時間
		LocalDateTime now = LocalDateTime.now();
		System.out.println("系統當前時間" + now);
		
		//獲取指定日期時間
		LocalDateTime localDateTime = LocalDateTime.of(2025, 07, 06, 12,00,00);
		System.out.println(localDateTime);
		
		//加年跟秒
		LocalDateTime localDateTime1 = localDateTime.plusYears(1).plusSeconds(1);
		System.out.println(localDateTime1);
		
		//減兩年
		LocalDateTime localDateTime2 = localDateTime1.minusYears(2); 
		System.out.println(localDateTime2);
	}
}
