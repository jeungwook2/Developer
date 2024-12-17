package server;

import java.io.BufferedReader;
import java.io.IOException;

import common.SocketInfo;

public class ServerMsgReceiver extends Thread {
	
	private BufferedReader br;
	private SocketInfo socketInfo;
	
	public ServerMsgReceiver(SocketInfo socketInfo) {
		this.socketInfo = socketInfo;
		this.br = socketInfo.getBr();
	}

	@Override
	public void run() {
		while(true) {
			try {Thread.sleep(1);} catch (InterruptedException e) {System.out.println("MsgReceiver interrupted");}
			String msg;
			try {
				msg = br.readLine();
				System.out.println("rcvd msg ::: " + msg);
				ServerMain.msgQueue.offer(msg);
				System.out.println("msgQ size : " + ServerMain.msgQueue.size());
			} catch (IOException e) {
				System.out.println("[ERROR] ServerMsgReceiver msg read fail ...");
				socketInfo.destroy();
				e.printStackTrace();
				break;
			}
		}
		
	}

}
