package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("===== Client =====");
		
		String ip = "192.168.40.111";
		int port = 12345;
		Socket s = new Socket(ip, port);
		
		System.out.println("연결 성공 !");
		
		//send
		OutputStream os = s.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true); // true => auto flush();
		pw.println("hello~~~");
//		pw.flush();
		System.out.println("메세지 전송 완료 !");
		
		//receive
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String str = br.readLine();
		System.out.println("서버가 되돌려준 메세지 : " + str);
	}
	
}
