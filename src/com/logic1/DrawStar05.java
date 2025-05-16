package com.logic1;

//    *
//   ***
//  *****
// *******
//*********
//有5行  1.2.3.4.5
//空白數 4.3.2.1.0
//星星數 1.3.5.7.9
public class DrawStar05 {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5 - i; j++) { // 空白數
				System.out.print(" ");
			}
			for (int k = 1; k <= i * 2 - 1; k++) { //印星星
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
