package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println("===== I/O =====");
		
		// "D 드라이브의 hello.txt 파일" 을 객체로 준비
		File f = new File("D:" + File.separator + "hello.txt");
		
		// 파일객체에 (문자열 데이터를 내보내는) 통로 연결
		FileWriter fw = new FileWriter(f);
		
		// 통로 이용하여 문자열 내보내기
		fw.write("zzzzzzzzzzzzzzzzzzzzzzzZ");
//		fw.flush(); 통로에 걸려있는 내용물을 내려주는 역할
		fw.close(); // fw.close() 가있으면 fw.flush(); 가 자동 실행됨
		
	}//main

}//class
