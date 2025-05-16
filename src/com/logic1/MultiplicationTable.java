package com.logic1;

//九九乘法表
//1*1=1 1*2=2 1*3=3 ......1*9=9 
//2*1=2 2*3=6 2*9=18 ...

public class  MultiplicationTable  {
	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		// 控制外迴圈
		for (i = 1; i <= 9; i++) {
			for (j = 1; j <= 9; j++) {
				System.out.print(i + "*" + j + "=" + i * j +"\t");
			}
			System.out.println();
		}

	}
}
