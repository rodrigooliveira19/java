package br.com.softblue.java.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPMultCastClient {

public static void main(String[] args) throws IOException {
		
		try(DatagramSocket socket = new DatagramSocket()) {
			
			String str = "Olá bem vindo a softblue......"; 
			
			byte[] buffer = str.getBytes(); 
			
			//InetAddress addr = InetAddress.getLocalHost(); 
			//Para usar MultCast envia-se a SMS para um grupo
			InetAddress addr2 = InetAddress.getByName("228.5.6.7"); 
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr2, 2500);
			socket.send(packet);
		}
	}

}
