package com.collectionmethod2;
//大樂透要排序、不重復、如果個位數的話前面補0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//例:01、05、16.....回傳string陣列

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

//找到要排序的方法
//個位數前面補0
//回傳String陣列 String[] playLotto()

public class PlayLotto {
	// 第三題
	// TreeSet排序，不重複
	public String[] playLotto() {

		Set<Integer> set = new TreeSet();
		Random random = new Random();
		// 產生0-99 隨機數字
		while (set.size() < 6) {
			// 把每次隨機選的數字拿出來(number)，丟進set集合裡
			int number = random.nextInt(100);// 0-99
			System.out.println(number);
			set.add(number);
		}

//		for(int i = 0; i < set.size();i++) {
//			int number = random.nextInt(100);
//			System.out.println(number);
//			
//		}

		// 個位數前面補0
		// 創建一個新的陣列
		String[] result = new String[6];
		int index = 0;
		// 把剛剛set集合裡的數字拿出來，要二位數，且沒有二位數的前面幫補一個0，再丟進result集合裡
		for (int num : set) {
			result[index++] = String.format("%02d", num);
		}
		return result;

	}

	// 題目 4：回傳原始 TreeSet
	public TreeSet playLottoSet() {

		TreeSet set = new TreeSet();
		Random random = new Random();

		while (set.size() < 6) {
			int number = random.nextInt(100);
			set.add(number);
		}
		return set;
	}

	// 題目5 public ArrayList playLottoList(String[] lotto)
	public ArrayList<String> playLottoList(String[] lotto) {

		ArrayList<String> arrayList = new ArrayList<>();
		for (String number : lotto) {
			arrayList.add(number);
		}
		return arrayList;

	}

	// 題目 6：把 TreeSet 的資料依順序放進 HashMap（key = 第幾個數字）
	public HashMap<Integer, Integer> playLottoMap(TreeSet<Integer> lotto) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		int index = 1;
		// 把TreeSet拿到的參數一一塞進map集合裡
		for (int num : lotto) {
			hashMap.put(index++, num);
		}
		return hashMap;

	}

	public static void main(String[] args) {

		PlayLotto playLotto = new PlayLotto();
		// 題目3
		String[] lottoArray = playLotto.playLotto();
		
		System.out.println("題目3  字串陣列：" + Arrays.toString(lottoArray));
		// 題目4
		TreeSet<Integer> lottoSet = playLotto.playLottoSet();
		System.out.println("題目4 TreeSet 集合：" + lottoSet);

		// 題目5
		ArrayList<String> lottoList = playLotto.playLottoList(lottoArray);
		System.out.println("題目5 ArrayList：" + lottoList);

		// 題目6
		HashMap<Integer, Integer> lottoMap = playLotto.playLottoMap(lottoSet);
		System.out.println("題目6  HashMap（key=順序）：" + lottoMap);
		
		
	}
}
