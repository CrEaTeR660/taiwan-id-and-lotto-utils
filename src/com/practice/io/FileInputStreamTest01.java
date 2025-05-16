package com.practice.io;

import java.io.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 字節輸入流，負責讀
 * 萬能流，任何文件都能讀，但還是建議讀取二進制文件(圖檔，語音檔，影片檔)
 * 也可以讀文本但容易出現亂碼
 * 
 * FileInputStream 構造方法:
 * FileInputStream(String name) 給路徑
 * 
 * FileInputStream 方法:
 * int read(); 調用一次read() 方法讀取一個字元，如果讀不到回傳-1
 * int read(byte[] b) 一次最多可以讀到b.length個字節(只要文字內容足夠多);返回值是讀取到的字節數輛，沒取道任何數值返回-1
 */
public class FileInputStreamTest01 {

	public static void main(String[] args) {

		InputStream in = null;
		try {
			in = new FileInputStream(
					"C:\\Users\\tony8\\eclipse-workspace\\JavaSEPractice\\src\\com\\practice\\io\\test.txt.txt");

//			int read = in.read(); // 返回讀到字節本身
//			System.out.println("第一次讀到的字節" + read);
//			read = in.read(); // 返回讀到字節本身
//			System.out.println("第一次讀到的字節" + read);
//			read = in.read(); // 返回讀到字節本身
//			System.out.println("第一次讀到的字節" + read);
//
//			read = in.read(); // 返回讀到字節本身
//			System.out.println("第一次讀到的字節" + read);

			int readByte = 0;
			while ((readByte = in.read()) != -1) {
				System.out.println("每次讀到的每位數"+readByte);
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			if (in != null) {

				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
