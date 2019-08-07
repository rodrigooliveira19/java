package br.com.softblue.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.NumberFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(2525); 
		
		while(true) {
			System.out.println("Servidor Aguardando requisição.......");
			Socket clientSocket = socket.accept(); 
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String tipo = in.readLine(); 
			
			if(tipo.equals("PAGAMENTO")) {
				processarPagamento(out, in);
				
			}else {
				System.out.println("Não li o pagamento");
			}

		}

	}
	
	private static void processarPagamento(PrintWriter out, BufferedReader in) {
		
		int qtd;

		try {
			qtd = Integer.parseInt(in.readLine());

		} catch (Exception e) {
			out.println("Falha: " + e.getMessage());
			return;
		}

		for (int i = 0; i < qtd; i++) {

			try {
				String infoPagStr = in.readLine();

				String[] tokens = infoPagStr.split(";");

				String nome = tokens[0];
				String numCartao = tokens[1];
				// Converte uma String para o formato de data.
				YearMonth dtValidadeCartao = YearMonth.parse(tokens[2], DateTimeFormatter.ofPattern("MM/yyyy"));
				int parcelas = Integer.parseInt(tokens[3]);
				double valor = Double.parseDouble(tokens[4]);

				System.out.println("Pagamento recebido (" + (i + 1) + ")");
				System.out.println("Nome: " + nome);
				System.out.println("Numero do Cartao: " + numCartao);
				System.out.println("Data de Validade do Cartão: " + dtValidadeCartao);
				System.out.println("Parcelas " + parcelas);
				System.out.println("Valor: " + NumberFormat.getCurrencyInstance().format(valor));

				out.println("OK");

			} catch (Exception e) {
				out.println("Falha: " + e.getMessage());
			}

		}
		
	}

}
