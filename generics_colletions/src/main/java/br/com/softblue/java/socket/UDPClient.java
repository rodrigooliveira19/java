package br.com.softblue.java.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	
	public static void main(String[] args) throws IOException {
		
		try(DatagramSocket socket = new DatagramSocket()) {
			
			String str = "Olá bem vindo a softblue......"; 
			
			byte[] buffer = str.getBytes(); 
			
			InetAddress addr = InetAddress.getLocalHost(); 
			//InetAddress addr2 = InetAddress.getByName("IP"); 
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, 2500);
			socket.send(packet);
		}
	}

}
