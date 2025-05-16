package com.logic1;

import java.util.Random;

//成績分類 : 產生20個亂數，再做分類
//90-100→甲
// 80-90→乙
//  …

public class RandomNumbers {
	public static void main(String[] args) {

		        Random rand = new Random();
		        //創建一個陣列裝20個數字
		        int[] scores = new int[20];

		        // 產生 20 個亂數 (0~100)
		        for (int i = 0; i < scores.length; i++) {
		            scores[i] = rand.nextInt(101); // 把0 to 100 隨機抽到的數字丟到陣列裡
		        }

		        // 顯示分數與等級
		        for (int score : scores) {
		            System.out.print("分數: " + score + " → 等級: ");
		            if (score >= 90) {
		                System.out.println("甲");
		            } else if (score >= 80) {
		                System.out.println("乙");
		            } else if (score >= 70) {
		                System.out.println("丙");
		            } else if (score >= 60) {
		                System.out.println("丁");
		            } else {
		                System.out.println("戊");
		            }
		        }
		    }
		}

