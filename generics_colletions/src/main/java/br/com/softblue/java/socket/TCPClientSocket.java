package br.com.softblue.java.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientSocket {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		try(Socket socket = new Socket("localhost", 1500)) {
			System.out.println("Cliente conectado ao Servidor: ....");
			
			int valor = 10; 
			OutputStream socketOut = socket.getOutputStream(); 
			DataOutputStream dOut = new DataOutputStream(socketOut); 
			
			dOut.writeInt(valor);
			System.out.println("Cliente: Valor "+valor+" enviado para o servidor");
			
			InputStream socketIn = socket.getInputStream(); 
			DataInputStream dIn = new DataInputStream(socketIn); 
			
			int valorRetorno = dIn.readInt(); 
			System.out.println("Cliente: Recebido do servidor valor "+valorRetorno);
			
		}
		
		
		
		
		
		
	}

}
