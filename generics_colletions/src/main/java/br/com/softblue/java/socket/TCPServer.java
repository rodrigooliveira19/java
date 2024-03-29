package br.com.softblue.java.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception{
		
		try(ServerSocket serverSocket = new ServerSocket(1500)) {
			System.out.println("Servidor: Aguardando requisição.....");
			Socket clientSocket = serverSocket.accept(); 
			
			InputStream socketIn = clientSocket.getInputStream();  
			DataInputStream din = new DataInputStream(socketIn); 
			
			int valor = din.readInt(); 
			System.out.println("Servidor recebeu o valor: "+valor); 
			valor++; 
			
			OutputStream socketOut = clientSocket.getOutputStream(); 
			DataOutputStream dOut = new DataOutputStream(socketOut); 
			dOut.writeInt(valor);
			System.out.println("Servidor enviou o valor: "+valor);
			
			
		}
		

	}

}
