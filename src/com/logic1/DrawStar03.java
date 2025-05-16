package com.logic1;

//*****
//****
//***
//**
//*
//總共有5行 1.2.3.4.5
//星星數    5.4.3.2.1
public class DrawStar03 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
