package com.joker.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 网络编程模块内容，下面的是Client（客户端）的简易代码，可以简单说明工作原理，网络编程是
 */
/**
 * @author joker
 * @ClassName Client
 * @
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 6666);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String readLine = br.readLine();
		while (!"bye".equals(readLine)) {
			pw.println(readLine);
			pw.flush();
			System.out.println("从serve端接收到的内容：" + is.readLine());
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
