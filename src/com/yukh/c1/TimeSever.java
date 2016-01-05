package com.yukh.c1;

public class TimeSever {
	public static void main(String[] args) {
		int port = 9090;
		if (args != null && args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				
			}
		}
		MultiplexerTimeServer timeSever = new MultiplexerTimeServer(port);
		new Thread(timeSever, "NIO-MultiplexerTimeSever-001").start();
	}
}
