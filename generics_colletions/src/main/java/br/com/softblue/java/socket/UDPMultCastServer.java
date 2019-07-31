package br.com.softblue.java.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPMultCastServer {

	public static void main(String[] args) throws IOException {

		InetAddress addr = InetAddress.getByName("228.5.6.7");

		// USO DE MULTCASTSOCKET PARA LER SMS DE UM GRUPO.
		try (MulticastSocket socket = new MulticastSocket(2500)) {

			// REGISTRAMOS O SERVIDOR NO GRUPO
			socket.joinGroup(addr);

			byte[] buffer = new byte[1024];

			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			System.out.println("Servidor aguardando o recebimento de datagrama.....");

			socket.receive(packet);

			byte[] clientData = packet.getData();
			String clientDtaStr = new String(clientData, 0, packet.getLength());

			System.out.println("Servidor: Dado recebido do cliente foi: " + clientDtaStr);
			
			//SAI DO GRUPO. 
			socket.leaveGroup(addr);
			

		}

	}

}
