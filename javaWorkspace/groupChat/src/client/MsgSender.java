package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import common.SocketInfo;

public class MsgSender extends Thread {
	
	private SocketInfo socketInfo;
	private PrintWriter pw;

	public MsgSender(SocketInfo x) throws Exception {
		this.socketInfo = x;
		pw = socketInfo.getPw();
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {Thread.sleep(1);} catch (InterruptedException e) {}
			String msg = ClientMain.sc.nextLine();
			pw.println("[" + ClientMain.nick + "]" + msg);
		}
		
	}

}
