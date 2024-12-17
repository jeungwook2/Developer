package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main02 {

	public static void main(String[] args) throws Exception {

		System.out.println("===== I/O =====");
		
		// "D 드라이브의 hello.txt 파일" 을 객체로 준비
		File f = new File("D:" + File.separator + "hello.txt");
		
		// 파일객체에 (문자열 데이터를 읽어들이는) 통로 연결
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		// 통로 이용하여 문자열 읽어오기
		String str = br.readLine();
		System.out.println(str);
		
	}

}
