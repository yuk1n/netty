package com.yukh.c1.nio;

public class TimeClient {
	public static void main(String[] args) {
		int port = 8889;
		if (args != null && args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch(NumberFormatException e) {
				
			}
		}
		new Thread(new TimeClientHandler("127.0.0.1", port), "TimeClient-001").start();
	}
}
