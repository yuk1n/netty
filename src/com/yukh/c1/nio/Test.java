package com.yukh.c1.nio;

import java.net.InetSocketAddress;

public class Test {
	
	public static void main(String[] args) {
		InetSocketAddress isa = new InetSocketAddress(8889);
		System.out.println("port:" + isa.getPort());
		System.out.println("address:" + isa.getAddress());
		System.out.println("" + isa.getHostName());
		System.out.println("" + isa.getHostString());
		System.out.println(1 << 4);
		
	}
}
