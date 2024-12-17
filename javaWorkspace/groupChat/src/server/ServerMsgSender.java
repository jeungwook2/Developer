package server;

import common.SocketInfo;

public class ServerMsgSender extends Thread {
	
	@Override
	public void run() {
		
		while(true) {
			try {Thread.sleep(1);} catch (InterruptedException e) {System.out.println("MsgSender interrupted");}
			if(ServerMain.msgQueue.isEmpty()) {
				continue;
			}
			String msg = ServerMain.msgQueue.poll();
			for(int i = 0; i < ServerMain.clientList.size(); ++i) {
				SocketInfo socketInfo = ServerMain.clientList.get(i);
				socketInfo.getPw().println(msg);
			}
		}
		
	}

}
