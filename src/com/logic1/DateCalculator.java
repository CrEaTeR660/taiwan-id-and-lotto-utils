package com.logic1;
//輸入年月日加天數，得出計算出的時間點
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
//未解決，假如閏年或不是閏年的年份，日期也會影響
public class DateCalculator {

	// 指定格式DateTimeFormatter比SimpleDateFormat更安全
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
			.withResolverStyle(ResolverStyle.STRICT);//STRICT嚴謹模式
			
	// 計算日期加上天數
	public static LocalDate ComputationDate(String dateStr, int dateNum) {
		
		LocalDate date = LocalDate.parse(dateStr, formatter); // 將輸入String轉換為物件
		return date.plusDays(dateNum); // 加上天數
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//定義好輸入時間
		//跟初始化日期
		String inputDate;
		LocalDate date = null;

		// 持續要求輸入直到日期格式正確
		while (true) {
			System.out.print("請輸入日期 (格式: uuuu-MM-dd)：");
			inputDate = scanner.nextLine();
			try {
				date = LocalDate.parse(inputDate, formatter);
				//*****未解決，輸入1999-02-31會過，它會自動帶到03-01
				//可以嚴謹規避掉不合法的年月日(使用DateTimeFormatter的ResolverStyle.STRICT模式)
				break; // 成功轉換就跳出迴圈
			} catch (DateTimeParseException e) {
				System.out.println("輸入的日期無效，請重新輸入！");
			}
		}

		// 輸入天數
		System.out.print("請輸入要加上的天數：");
		int addDays = scanner.nextInt();

		// 計算並印出結果
		LocalDate newDate = date.plusDays(addDays);
		System.out.println("原本日期: " + inputDate);
		System.out.println("加上 " + addDays + " 天後的日期: " + newDate);

		scanner.close();
	}
}

