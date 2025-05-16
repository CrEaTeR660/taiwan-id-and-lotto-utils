package com.io3;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LottoApp {

	public static void main(String[] args) {
		writeLottoToFile(); // 題目 1
		copyLottoWithDate(); // 題目 2
		queryAndWriteSingleLotto(15); // 題目 3（查詢第20筆資料）
		generate20LottoFiles(); // 題目 4
		zipLottoFiles(); // 題目 5
	}

	// 題目 1：產生 100 筆大樂透並寫入 Lotto.txt
	public static void writeLottoToFile() {
		// 用bufferedWriter裝
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Lotto.txt"))) {
			// 輸出100筆大樂透輸出的結果
			for (int i = 1; i <= 100; i++) {
				writer.write("第" + i + "筆樂透: " + generateLottoNumbers());
				// 寫入一個，換行，按enter
				writer.newLine();
			}
			System.out.println("Lotto.txt 產生完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 題目 2：複製 Lotto.txt 成為 Lotto_yyyyMMdd.txt 到我要的資料夾
	public static void copyLottoWithDate() {
		// 取得今天日期，自訂日期格式化(yyyyMMdd)
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		// 拿到Lotto.txt檔案
		Path source = Paths.get("Lotto.txt");
		// 複製的目的地
		Path target = Paths.get("src/com/io3/Lotto_" + today + ".txt");

		try {
			// 如果 資料夾不存在，則自動建立（確保父資料夾存在）
			Files.createDirectories(target.getParent());
			// 複製檔案，如果目標檔案已存在就覆蓋（REPLACE_EXISTING）
			// files.copy方法 Path copy(Path source, Path target, CopyOption... options)
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("V 已複製為 " + target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 題目 3：查詢某一筆並將資料縱向輸出至 Lotto_new.txt
	// 要先讀取哪個資料
	// 讀取到資料裡的每一行資料
	// 將讀到的資料每一筆寫進新的資料裡並換行
	// 假如沒讀到的資料，印出錯誤訊息，並斷
	// 查詢第 index 筆樂透資料並輸出到新檔案中

	public static void queryAndWriteSingleLotto(int index) {
		// 用BufferedReader或BufferedWriter裝，處理大量資料比較快
		// 讀取
		try (BufferedReader reader = new BufferedReader(new FileReader("Lotto.txt"));
				// 寫入輸出檔案 Lotto_new.txt，用於寫出指定樂透資料
				BufferedWriter writer = new BufferedWriter(new FileWriter("Lotto_new.txt"))) {

			// 將 Lotto.txt 中的所有行讀入成 List<String>
			List<String> lines = reader.lines().toList();
			//
			if (index < 1 || index > lines.size()) {
				System.out.println("x 查無第 " + index + " 筆資料");
				return;
			}

			String line = lines.get(index - 1); // 取得第 index 筆（List 從 0 開始）
			// 是將字串根據空格分割成一個字符串數組
			// 把07 23 34 35 38 41 -> ["07", "23", "34", "35", "38", "41"]
			String[] numbers = line.split(" "); // 用空格分開號碼

			// 將每一個樂透號碼寫入新檔，每個號碼各佔一行
			for (String num : numbers) {
				writer.write(num);
				writer.newLine();
			}

			System.out.println("V 第 " + index + " 筆樂透已輸出至 Lotto_new.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 題目 4：產生 20 個 Lotto_01.txt ~ Lotto_20.txt，每個有 100 筆
	public static void generate20LottoFiles() {
		try {
			// 建立一個資料夾lottofiles
			Files.createDirectories(Paths.get("lottofiles"));

			// 為了讓他順序性，生產檔案順序01，02.....，後面參數i動態生產順序檔案
			for (int i = 1; i <= 20; i++) {
				String filename = String.format("lottofiles/Lotto_%02d.txt", i);

				// 產生一個檔案裏面有100筆1-100的樂透
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
					for (int j = 1; j <= 100; j++) {
						writer.write("第" + j + "筆樂透: " + generateLottoNumbers());
						writer.newLine();
					}
				}
			}
			System.out.println("產生 20 個 Lotto_XX.txt 完成！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void zipLottoFiles() {
		// 建立代表要壓縮的資料夾的 File 物件
		File folder = new File("lottofiles");
		// 建立壓縮後要輸出的 zip 檔案物件
		File zipFile = new File("LottoFiles.zip");

		// 建立輸出 zip 檔案的檔案輸出流
		try (FileOutputStream fos = new FileOutputStream(zipFile);
				// 建立 Zip 輸出串流，包裝在 FileOutputStream 外層
				ZipOutputStream zos = new ZipOutputStream(fos)) {

			// 取得資料夾內所有的檔案
			File[] files = folder.listFiles();
			if (files == null) {
				System.out.println(" 資料夾不存在或為空");
				return;
			}

			// 逐一處理每一個檔案
			for (File file : files) {

				// 如果是檔案（不是資料夾）才處理
				if (file.isFile()) {
					try (FileInputStream fis = new FileInputStream(file)) {
						
						//我用 FileInputStream 搭配 ZipOutputStream，
						//透過 ZipEntry 建立 zip 壓縮項目。
						//然後我用 byte 陣列作為緩衝區（byte[] buffer = new byte[1024]），
						//搭配 while 迴圈，每次從檔案讀取最多 1024 bytes（fis.read(buffer)），
						//再用 zos.write(buffer, 0, length) 寫入壓縮檔。這種方式可以處理大檔案，不會一次吃光記憶體						// 建立一個 zip 項目（檔案在 zip 中的名稱）
						ZipEntry entry = new ZipEntry(file.getName());
						// 將該 zip 項目加入 zip 輸出串流
						zos.putNextEntry(entry);

						byte[] buffer = new byte[1024];//準備緩衝區
						int length;

						// 讀取檔案資料並寫入 zip 中，邊讀取邊寫入
						while ((length = fis.read(buffer)) > 0) {
							zos.write(buffer, 0, length);
						}

						zos.closeEntry();
					}
				}
			}

			System.out.println("LottoFiles.zip 壓縮完成！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 樂透號碼產生器（每組 6 個不重複號碼，1~49）
	private static String generateLottoNumbers() {
		Random random = new Random();
		Set<Integer> numbers = new TreeSet<>();
		while (numbers.size() < 6) {
			numbers.add(random.nextInt(49) + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int num : numbers) {
			// 如果不為二位數前面補個0
			sb.append(String.format("%02d ", num));
		}
		return sb.toString().trim();
	}
}
