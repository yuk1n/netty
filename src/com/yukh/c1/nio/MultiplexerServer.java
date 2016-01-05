package com.yukh.c1.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerServer implements Runnable{
	private Selector selector;
	private ServerSocketChannel servChannel;
	private volatile boolean stop;
	
	public MultiplexerServer(int port) {
		try {
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port : " + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void stop() {
		this.stop = true;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) 
								key.channel().close();
						}
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		//多路复用器关闭后，所有注册在上面的channel和pipe 都会自动关闭
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			if (key.isAcceptable()) {
				
			}
		}
	}
	
}
