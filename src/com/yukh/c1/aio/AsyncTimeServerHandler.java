package com.yukh.c1.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {
	
	CountDownLatch latch;
	AsynchronousServerSocketChannel asyServSocketChannel;
	
	public AsyncTimeServerHandler(int port) {
		try {
			asyServSocketChannel = AsynchronousServerSocketChannel.open();
			asyServSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server is start in port : " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void doAccept() {
		asyServSocketChannel.accept(this, new AcceptCompletionHandler());
	}
	
}
