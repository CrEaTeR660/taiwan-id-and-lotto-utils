package com.practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserSystem {

	private static List<User> users = new ArrayList();

	
	// 註冊
	public static boolean register(String username, String password, String email) {
		
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				System.out.println("帳戶已存在");
				return false;

			}
		}
		users.add(new User(username, password, email));
		System.out.println("註冊成功 !");
		return true;
	}
	
	//登入
	public static boolean login(String username, String password) {
		
		for(User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("登入成功！");
                return true;
            }
		}
		System.out.println("帳號密碼輸入錯誤!");
		return false;
		
	}
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("請選擇操作：1.註冊  2.登入  3.離開");
	            String choice = sc.nextLine();

	            if (choice.equals("1")) {
	                System.out.print("帳號：");
	                String username = sc.nextLine();
	                System.out.print("密碼：");
	                String password = sc.nextLine();
	                System.out.print("Email：");
	                String email = sc.nextLine();
	                register(username, password, email);
	                
	            } else if (choice.equals("2")) {
	                System.out.print("帳號：");
	                String username = sc.nextLine();
	                System.out.print("密碼：");
	                String password = sc.nextLine();
	                login(username, password);
	                
	            } else if (choice.equals("3")) {
	                System.out.println("系統已關閉！");
	                break;
	            } else {
	                System.out.println("請輸入有效選項！");
	            }
	        }

	        sc.close();
	    }
	
}
