package com.joker.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author joker
 * @ClassName Serve @
 */
public class Serve {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(6666);
			socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("从client端接收的信息为：" + is.readLine());
		String readLine = br.readLine();
		while (!"bye".equals(readLine)) {
			pw.println(readLine);
			pw.flush();
			System.out.println("从client端接收的信息为：" + is.readLine());
			System.out.println("serve端发出的信息为：" + readLine);
			readLine = br.readLine();
		}
		if (is != null) {
			is.close();
		}
		if (pw != null) {
			pw.close();
		}
		if (br != null) {
			br.close();
		}
	}
}
