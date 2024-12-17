package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import common.SocketInfo;

public class ClientMain {
	
	public static Scanner sc;
	public static String nick;
	
	static {
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("===== CLIENT MAIN =====");
		
		System.out.print("채팅에 사용할 닉네임 : ");
		nick = sc.nextLine();
		
		System.out.print("접속할 서버의 IP : ");
		String ip = sc.nextLine();
		
		int port = 12345;
		
		try {
			Socket socket = new Socket(ip , port);
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream() , true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			SocketInfo socketInfo = new SocketInfo(socket, pw, br);
			
			System.out.println(ip + ":" + port + " 연결 성공 !");
			new MsgSender(socketInfo).start();
			new MsgReceiver(socketInfo).start();
		} catch (IOException e) {
			System.out.println("연결 실패 ...");
			e.printStackTrace();
		}
		
	}//main

}//class
