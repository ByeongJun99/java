package com.kh.Test240214_3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		
		int port = 3000;
		String serverIP;
		
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIP, port);
			
			// 이하 코드 생략
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

