package com.practice.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//日期格式化，需要借助DateFormat，是Date的子類
//有text代表處理日期格式化的
//有個子類是SimpleDateFormat是DateFormat的子類
public class DateTest02 {
	public static void main(String[] args) throws ParseException  {
		
		//java.util.Date --> java.lang.String
		//獲取系統當前時間
		Date now = new Date();
		//格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		
		//調用format格式化
		String str = sdf.format(now);
		System.out.println(str);
		
		
		//java.lang.String --> java.util.Date
		String strDate = "2025-05-06 09:42:15 194";
		//創建日期格式化
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		
		//解析字符串-->將字符串String轉成Date
		Date date = sdf2.parse(strDate);
		System.out.println(date);
	}
}
