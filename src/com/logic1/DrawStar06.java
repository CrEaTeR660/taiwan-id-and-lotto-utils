package com.logic1;
//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *

//上半段
//行數   1.2.3.4.5
//空白數 4.3.2.1.0
//星星數 1.3.5.7.9

//下半段
//行數   1.2.3.4
//空白數 1.2.3.4
//星星數 7.5.3.1
public class DrawStar06 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) { // 上半段行數
			for (int j = 1; j <= 5 - i; j++) { // 上半段空白數
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) { // 上半段星星數
				System.out.print("*");
			}
			System.out.println();
		}
		// 下半段
		for (int a = 1; a <= 4; a++) { // 下半段行數
			for (int b = 1; b <= a; b++) {
				System.out.print(" ");
			}
			for (int c = 1; c <= 2 * (5 - a) - 1; c++) { // 星星數 這個沒想到2 * (5 - a) - 1
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
