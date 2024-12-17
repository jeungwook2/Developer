package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws Exception {
		
		ClientMain cm = new ClientMain();
		
		System.out.println("===== Server =====");

		ServerSocket ss = new ServerSocket(12345); //12345 포트에 서버소켓 생성
		Socket socket = ss.accept(); // 서버 소켓한테 연결 대기하라고 명령
		
		System.out.println(socket + " 연결됨");
		
		//receive
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
// BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		
		String str = br.readLine();
		System.out.println("클라이언트로부터 전달받은 메세지 : " + str);
		
		//send
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		pw.println(str);
		
	}//main

}//class
