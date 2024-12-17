package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import common.SocketInfo;

public class ServerMain {
	
	public static Queue<String> msgQueue = new LinkedList<String>();
	public static ArrayList<SocketInfo> clientList = new ArrayList<SocketInfo>();

	public static void main(String[] args) {

		System.out.println("===== SERVER MAIN =====");
		
		ServerSocket ss = null;
		try {
			int port = 12345;
			ss = new ServerSocket(port);
			
			new ServerMsgSender().start();
			
			while(true) {
				Thread.sleep(1);
				Socket client = ss.accept();
				System.out.println("[CONNECT] " + client);
				
				PrintWriter pw = new PrintWriter(client.getOutputStream() , true);
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				SocketInfo socketInfo = new SocketInfo(client, pw, br);
				clientList.add(socketInfo);
				
				new ServerMsgReceiver(socketInfo).start();
			}
			
		} catch (IOException e) {
			System.out.println("[ERROR] server socket create err ...");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("[ERROR] sleep interrupted ...");
			e.printStackTrace();
		}finally {
			try {
				if(!ss.isClosed()) {ss.close();}
			} catch (IOException e) {}
		}
		
		
		
	}//main

}//class


























