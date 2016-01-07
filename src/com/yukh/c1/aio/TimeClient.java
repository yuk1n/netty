package com.yukh.c1.aio;

public class TimeClient {
	public static void main(String[] args) {
		int port = 8889;
		if (args != null && args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (Exception e) {
				
			}
		}
		new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
	}
}
