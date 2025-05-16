package com.logic1;

//    *
//   **
//  ***
// ****
//*****
//4 1
//3 2
//2 3
//1 4
//0 5
public class DrawStar02 {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			
			for (int j = 1; j <= 5 - i; j++) { // 印空白
				System.out.print(" ");
			}
			
			for (int k = 1; k <= i; k++) { // 印星星
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
