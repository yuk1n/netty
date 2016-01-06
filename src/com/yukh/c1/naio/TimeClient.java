package com.yukh.c1.naio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
	public static void main(String[] args) {
		int port = 8889;
		if (args != null && args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				
			}
		}
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("QUERY TIME ORDER");
			System.out.println("Send order 2 server succeed.");
			String resp = in.readLine();
			System.out.println("Now is : " + resp);
		} catch (Exception e) {
			
		} finally {
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
					in = null;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
					socket = null;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
