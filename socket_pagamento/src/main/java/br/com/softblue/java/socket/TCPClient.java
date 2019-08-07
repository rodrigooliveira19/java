package br.com.softblue.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		try (Socket socket = new Socket("localhost", 2525)) {
			System.out.println("Cliente conectado com Sucesso");

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			int qtd = 3;
			
			out.println("PAGAMENTO");
			out.println(qtd);

			for (int i = 0; i < qtd; i++) {
				String status = enviarPagamento("MARCOS FERREIRA MARTINS", "879233332102", YearMonth.of(2019, 3), "1",
						90.87, out, in);

				if (status == null) {
					System.out.println("Pagamento processado com sucesso");
				} else {
					System.out.println("Pagamento recusado: " + status);
				}

			}

		}

	}

	// Poderiamos cria uma classe pagamento para encapsular todos os parametros.
	private static String enviarPagamento(String nome, String numCartao, YearMonth dtValidade, String parcelas,
			double valor, PrintWriter out, BufferedReader in) throws IOException {

		out.println(String.format("%s;%s;%s;%s;%s", nome, numCartao,
				dtValidade.format(DateTimeFormatter.ofPattern("MM/yyyy")), parcelas, String.valueOf(valor)));

		String status = in.readLine();

		if (status.equals("OK")) {
			return null;
		} else {
			return status;
		}

	}

}
