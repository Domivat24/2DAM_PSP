package ExamenMultiHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String args[]) throws IOException {
		try (
				Socket socket = new Socket("localhost", 60000)) {
			// Creo los flujos de entrada y salida
			PrintWriter fsalida = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Flujo para la lectura por teclado
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			String cadena, cadenaRecibida;

			System.out.println("Introduce cadenas hasta que introduzcas *. Entonces recibe todas las cadenas ordenadas por orden alfabético.");
			do {
				System.out.println("Introduce cadena: ");
				cadena = in.readLine();
				fsalida.println(cadena);

			} while (!(cadena.contentEquals("*")));

			cadenaRecibida = fentrada.readLine();
			System.out.println("Recibo cadena compuesta y ordenada: " + cadenaRecibida);
			System.out.println("Fin comunicación.");

			// Cierros los flujos
			fsalida.close();
			fentrada.close();
			in.close();
			socket.close();
		}
	}
}
