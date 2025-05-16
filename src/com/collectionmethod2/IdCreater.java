package com.collectionmethod2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//身分證產生器
/*
 * 規則
 * 隨機生成，英文字母大寫(A-Z)
 * 把拿到的英文字母，算成數字(乘積)
 * 生成，第二碼1、2(男或女)
 * 生成，第3-9碼 0-9隨機數字(共7位數)
 * 生成，檢查碼 = 10 - (乘積和%10) % 10
 * 算出拿到數字的乘積和
 * 
 * (前九碼成績和+X)%10 ==0
 * 驗證所有乘積和%10是否==0 (假設% == 0 PASS)
 * 組合完整身分證字號
 */
public class IdCreater {

//	隨機生成，英文字母大寫(A-Z)
	public static char createAZLetters(char letter) {

		Random random = new Random();
		return (char) ('A' + random.nextInt(26)); // 'A'-> 65 'B'->(65+1)以此類推
		// 這樣會return隨機一個char字母
	}

//	字母 A~Z 對應的數字（例如 A→10, B→11, ..., Z→33）
	private static final Map<Character, Integer> letterToNumberMap = new HashMap<>();

	static {
		letterToNumberMap.put('A', 10);
		letterToNumberMap.put('B', 11);
		letterToNumberMap.put('C', 12);
		letterToNumberMap.put('D', 13);
		letterToNumberMap.put('E', 14);
		letterToNumberMap.put('F', 15);
		letterToNumberMap.put('G', 16);
		letterToNumberMap.put('H', 17);
		letterToNumberMap.put('I', 34);
		letterToNumberMap.put('J', 18);
		letterToNumberMap.put('K', 19);
		letterToNumberMap.put('L', 20);
		letterToNumberMap.put('M', 21);
		letterToNumberMap.put('N', 22);
		letterToNumberMap.put('O', 35);
		letterToNumberMap.put('P', 23);
		letterToNumberMap.put('Q', 24);
		letterToNumberMap.put('R', 25);
		letterToNumberMap.put('S', 26);
		letterToNumberMap.put('T', 27);
		letterToNumberMap.put('U', 28);
		letterToNumberMap.put('V', 29);
		letterToNumberMap.put('W', 32);
		letterToNumberMap.put('X', 30);
		letterToNumberMap.put('Y', 31);
		letterToNumberMap.put('Z', 33);
	}

	// 判斷字母有沒有在對應的map裡
	public static int getMappedNumber(char letter) {
		if (!letterToNumberMap.containsKey(letter)) { // 假設字母沒有在對應的map裡
			throw new IllegalArgumentException("非法字母：" + letter);
		}
		return letterToNumberMap.get(letter);
	}

	// 生成第二碼 1 或 2（代表男或女）
	public static String getRandomGenderDigit() {
		Random random = new Random();
		int gender = random.nextInt(2) + 1; // 出來是0或1 +1 -> 1 或 2
		return String.valueOf(gender);
	}

//生成，第3-9碼 0-9隨機數字(共7位數)
	public static int[] createRandomNumbers() {
		Random random = new Random();
		int[] numbers = new int[7];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10); // 產生 0~9 的亂數
		}

		return numbers;
	}

	// 計算英文(數字)+後8位數的乘積和(權重);不算檢查碼
	public static int totalLegal(int[] letterDigits, int[] numberDigits) {

		int[] weights = { 1, 9, 8, 7, 6, 5, 4, 3, 2, 1 }; // 每個位置*的數字(最後檢查碼不會算到)
		int total = 0;
		// 先算前面英文字母的數字乘積
		System.out.println("英文字母十位: " + letterDigits[0] + " * " + weights[0]);
		total += letterDigits[0] * weights[0]; // 英文十位

		System.out.println("英文字母十位: " + letterDigits[1] + " * " + weights[1]);
		total += letterDigits[1] * weights[1]; // 英文個位

		// 再算後面8位數字的數字乘積
		for (int i = 0; i < 8; i++) { // 9個數字乘積
			System.out.println("數字: " + numberDigits[i] + " * " + weights[i + 2]);

			total += numberDigits[i] * weights[i + 2]; // 後9位數字，跳過英文字母
		}
		System.out.println(total);
		return total;
	}

	// 生成檢查碼：10 - (總和 % 10) % 10
	public static int createCheckNumber(int total) {
		return (10 - (total % 10)) % 10;
	}

	// ===============================================================================================================

	public static void main(String[] args) {

		// 生成英文字母(因為我把A當初始化值)
		char firstLetter = createAZLetters('A');
		System.out.println(firstLetter);

		// 英文字母轉成兩位數（例如 A→10）
		int letterNumber = getMappedNumber(firstLetter);

		int[] letterDigits = { letterNumber / 10, // 十位
				letterNumber % 10 // 個位
		};

		// 生成第二碼(1、2 男生或女生)
		String gender = getRandomGenderDigit();
		System.out.println(gender);

		// 產生隨機 7 碼
		int[] randomSeven = createRandomNumbers();
		System.out.println(randomSeven);

		// 組合後8碼（性別碼 + 7碼）不包括英文跟最後一位檢查碼
		int[] numberDigits = new int[8];
		// 第1碼：性別碼
		numberDigits[0] = Integer.parseInt(gender);// 把拿到String gender轉成數字
		// 第2~8碼：隨機數字，丟進組合的陣列
		for (int i = 0; i < 7; i++) {
			numberDigits[i + 1] = randomSeven[i]; // 把我隨機生成的數字一個一個塞到numberDigits[];
			System.out.println("1數字: " + numberDigits[i]);
		}

		// 計算總和
		int total = totalLegal(letterDigits, numberDigits);
		System.out.println(total);

		// 產生檢查碼(拿到total再丟給createCheckNumber()去做生成檢查碼)

		int checkNumber = createCheckNumber(total);
		System.out.println(checkNumber);

		// 因為印出來是地址，所以要把每一個數字拿出來
		// 把 numberDigits 陣列轉成字串
		//用StringBuilder裝
		StringBuilder idNumberPart = new StringBuilder();
		for (int num : numberDigits) {
			idNumberPart.append(num);
		}

		// 組合整個身分證號碼：字母 + 數字8碼 + 檢查碼
		System.out.println("身分證產生器::" + firstLetter + idNumberPart.toString() + checkNumber);

		
	}
}
