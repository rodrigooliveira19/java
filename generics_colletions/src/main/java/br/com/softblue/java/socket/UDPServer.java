package br.com.softblue.java.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		
		try(DatagramSocket socket = new DatagramSocket(2500)) {
			
		 byte[] buffer = new byte[1024]; 
		 
		 DatagramPacket packet = new DatagramPacket(buffer, buffer.length); 
		 System.out.println("Servidor aguardando o recebimento de datagrama.....");
		 
		 socket.receive(packet);
		 
		 byte[]  clientData = packet.getData(); 
		 String clientDtaStr = new String(clientData, 0, packet.getLength()); 
		 
		 System.out.println("Servidor: Dado recebido do cliente foi: "+clientDtaStr);
		 
		} 
		
	}

}
