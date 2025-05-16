package com.logic1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//猜數字遊戲 0A0B (題目及回答需檢核不可有同樣數字)
//假設乙要猜甲的數字，以下是他們的對話內容：
//乙：1234
//甲：0A0B (此時我們可以確定這個4位數字絕對不會是1、2、3、4所組成。)
//乙：5678 (因此繼續猜5678)
//甲：0A3B
//乙：7865
//甲：3A0B
//乙：7860
//甲：4A0B
//直到甲方說出4A0B才算乙方真的猜中甲方的數字！

//1.	數字只能有4個
//2.	隨機產生四個數字
//3.	驗證是否數字不一樣
//4.	比對幾A幾B

public class NumberGuessingGame {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String answer = generateAnswer(); // 產生不重複的 4 位數
		String guess;

		while (true) {

			System.out.print("請輸入一組4位數（不重複）：");
			guess = scanner.nextLine();

			if (!isValid(guess)) {
				System.out.println("輸入格式錯誤，請輸入4位不重複的數字！");
				continue;
			}

			String result = checkAB(answer, guess);
			System.out.println(result);

			if (result.equals("4A0B")) {
				System.out.println("恭喜猜對了！答案是：" + answer);
				break;
			}
		}
	}

	// 隨機產生 4 位數字
	public static String generateAnswer() {
		List<Integer> digits = new ArrayList<>();

		Random rand = new Random();

		while (digits.size() < 4) {
			int num = rand.nextInt(10); // 隨機選 0~9
			if (!digits.contains(num)) { // 如果集合裡的數字不包刮隨機選的數字，添加進去
				digits.add(num);
			}
		}
		// 把數字組成字串
		StringBuilder sb = new StringBuilder();
		for (int d : digits) {
			sb.append(d);
		}
		// 回傳字串最終結果
		return sb.toString();
	}

	// 驗證輸入是否為 4 位不重複數字
	public static boolean isValid(String input) {

		if (input.length() != 4)
			return false;
		for (int i = 0; i < input.length(); i++) {

			// 方法檢查這個字符是否是數字Character.isDigit
			if (!Character.isDigit(input.charAt(i)))
				return false;
			//只要有一個字串重複多次給false
			if (input.indexOf(input.charAt(i)) != input.lastIndexOf(input.charAt(i)))
				return false;
		}
		return true;
	}

	// 比對幾A幾B
	public static String checkAB(String answer, String guess) {
		int A = 0, B = 0;
		// charAt()用來找某個字串的字元
		// 用for迴圈一一驗證每個數字是否正確，假如正確A++假如錯誤B++
		for (int i = 0; i < 4; i++) {
			//因為charAt所獲取到的是字元，所以前面用char接
			char g = guess.charAt(i);
			if (g == answer.charAt(i)) {
				A++;
				//把字元g轉成字串，再用contains看有沒有包含
			} else if (answer.contains(String.valueOf(g))) {
				B++;
			}
		}

		return A + "A" + B + "B";
	}
}
