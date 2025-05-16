package com.logic1;

//*****
// ****
//  ***
//   **
//    *
//有5行  1.2.3.4.5
//空白數 0.1.2.3.4
//星星數 5.4.3.2.1
public class DrawStar04 {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < i ; j++) { // 印空白
				System.out.print(" ");
			}
			for (int k = 1; k <= 6 - i; k++) { // 印星星
				System.out.print("*");
			}
			System.out.println();
		}
	}
}