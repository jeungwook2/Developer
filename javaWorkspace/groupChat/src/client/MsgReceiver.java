package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import common.SocketInfo;

public class MsgReceiver extends Thread {
	
	private SocketInfo socketInfo;
	private BufferedReader br;

	public MsgReceiver(SocketInfo x) throws Exception {
		this.socketInfo = x;
		this.br = socketInfo.getBr();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1);
				String msg = br.readLine();
				System.out.println(msg);
			} catch (Exception e) {
				System.out.println("[ERROR] MsgReveiver read fail ...");
				socketInfo.destroy();
				e.printStackTrace();
				break;
			}
		}
	}

}






