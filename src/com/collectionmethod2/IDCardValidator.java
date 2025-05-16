package com.collectionmethod2;

import java.util.Scanner;

//身分證驗證器
//長度：身份證號碼共計 10 碼（1 個英文字母 + 9 個數字）。
//首字母必須為字母，且是大寫字母（A~Z）
//第二到第九位：必須是 9 位數字（0~9）
//將乘上權數後之積相加
//相加後之值除以模數 10 取其餘數
//模數減去餘數得檢查號碼，若餘數為 0 時，則設定其檢查碼為 0
public class IDCardValidator {

	// 驗證男生女生
	public static boolean checkGender(char gender) {

		if (gender == '1') {
			System.out.println("男生");
			return true;
		} else if (gender == '2') {
			System.out.println("女生");
			return true;
		} else {
			System.out.println("輸入的數字不合法");
			return false;
		}
	}

//驗證首字是英文A-Z(且是大寫)
	public static boolean isFirstCharUppercaseLetter(String firstLetter) {
		if (firstLetter.matches("^[A-Z].*")) {
			return true;
		} else {
			throw new IllegalArgumentException("不是合法的大寫英文字母 A-Z");
		}
	}

	// 驗證身分證後面 9 碼是否為數字
	public static boolean isNumberLegal(String id) {
		// 必須是總長度10（1碼英文 + 9碼數字）
		if (id == null || id.length() != 10)
			return false;

		// 檢查後面9碼位置(數字)是否全部是數字 charAt(index x)
		for (int i = 1; i <= 9; i++) {
			if (!Character.isDigit(id.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// 算出A-Z對應的數字10-33 身分證A-Z 10~33 char ASCII 65~90 A-Z ，找到規則-55
	// 將英文 A-Z 轉成兩位數字陣列，例如 A → [1, 0]，B → [1, 1] ... Z → [3, 3]
	public static int[] letterToNumberArray(char letter) {
		// A-Z(10.11.12.13.14.15.16.17.34.18.19.20.21.22.23.24.25.26.27.28.28.32.30.31.33)沒有一定規律，
		int number;
		if (letter >= 'A' && letter <= 'H') {
			number = letter - 55; // A=65-55 -> 10
		} else if (letter == 'I') {
			number = 34;
		} else if (letter >= 'J' && letter <= 'N') {
			number = letter - 56;
		} else if (letter == 'O') {
			number = 35;
		} else if (letter >= 'P' && letter <= 'V') {
			number = letter - 57;
		} else if (letter == 'W') {
			number = 32;
		} else if (letter >= 'X' && letter <= 'Y') {
			number = letter - 58;
		} else if (letter == 'Z') {
			number = 33;
		} else {
			throw new IllegalArgumentException("輸入的英文字不對: " + letter);
		}
		return new int[] { number / 10, number % 10 }; // 為了拿到英文字母對應數字的十位數跟個位數
	}

	// 計算英文(數字)+後8位數的乘積(權重)
	public static int totalLegal(int[] letterDigits, int[] numberDigits) {

		int[] weights = { 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1 }; // 每個位置*的數字
		int total = 0;
		// 先算前面英文字母的數字乘積
		System.out.println("英文字母十位: " + letterDigits[0] + " * " + weights[0]);
		total += letterDigits[0] * weights[0]; // 英文十位

		System.out.println("英文字母十位: " + letterDigits[1] + " * " + weights[1]);
		total += letterDigits[1] * weights[1]; // 英文個位

		// 再算後面8位數字的數字乘積
		for (int i = 0; i < numberDigits.length; i++) { // 9個數字乘積
			System.out.println("數字: " + numberDigits[i] + " * " + weights[i + 2]);

			total += numberDigits[i] * weights[i + 2]; // 後9位數字，跳過英文字母
		}
		System.out.println(total);
		return total;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入正確身分證字號:(大寫英文字母+數字後9碼)");
		String id = scanner.nextLine();

		if (id.length() != 10) {
			System.out.println("身分證長度錯誤，應為 10 碼");
			return;
		}

		try {
			// 驗證第一個字母是否合法
			if (!isFirstCharUppercaseLetter(String.valueOf(id.charAt(0))))
				return;

			// 驗證後面9位數字是否合法
			if (!isNumberLegal(id)) {
				System.out.println("後面9位要是數字喔!");
				return;
			}

			// 直接從第2碼判斷性別
			char genderChar = id.charAt(1); // 取得第2碼
			checkGender(genderChar); // 呼叫 checkGender 方法進行性別判別

			//
			// 轉換英文字母 -> 數字（十位、個位）
			int[] letterDigits = letterToNumberArray(id.charAt(0));
			System.out.println("字母對應的兩位數: " + letterDigits[0] + " " + letterDigits[1]);
			
			
			// 把身分證第2~第10位轉成數字陣列(目的:用陣列裝每一個數字，方便我totalLegal去做使用)
			int[] numberDigits = new int[9];
			for (int i = 1; i <= 9; i++) {
				numberDigits[i - 1] = id.charAt(i) - '0'; // 用ascII碼互減會得到數字(i會是第一個位置到第九個位置)
			}

			// 把上面拿到的numberDigits，letterDigits分別丟到下面
			// 計算總和
			int total = totalLegal(letterDigits, numberDigits);
			System.out.println(total);
			// 驗證是否 total % 10 == 0
			if (total % 10 == 0) {
				System.out.println("身分證號碼正確");
			} else {
				System.out.println("身分證錯誤，因為總和 % 10不等於 0");
			}

		} catch (IllegalArgumentException e) {
			System.out.println("錯誤：" + e.getMessage());
		}
	}

}
