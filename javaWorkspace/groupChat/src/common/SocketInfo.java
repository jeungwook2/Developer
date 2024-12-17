package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import server.ServerMain;

public class SocketInfo {

	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;

	public SocketInfo(Socket socket, PrintWriter pw, BufferedReader br) {
		this.socket = socket;
		this.pw = pw;
		this.br = br;
	}

	public Socket getSocket() {
		return socket;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void destroy() {
		ServerMain.clientList.remove(this);
		try {
			br.close();
		} catch (IOException e) {
		}
		try {
			pw.write("[SYSTEM] 연결끊김 !!!");
		} catch (Exception e) {
		}
		pw.close();
		try {
			if (!socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
		}
	}

}
