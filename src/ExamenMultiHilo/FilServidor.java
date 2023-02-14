package ExamenMultiHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilServidor extends Thread {
	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;
	private List<String> cadenas = new ArrayList<>();


	// constructor FilServidor
	public FilServidor(Socket s) throws IOException {
		System.out.println("Creo hilo servidor");
		socket = s;
		// Creo los flujos
		fsalida = new PrintWriter(socket.getOutputStream(), true);
		fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	// Funcionalidades del servidor
	public void run() {
		try {
			String cadena = "";
			boolean parar = false;


			while (!cadena.trim().equals("*") && !parar) {
				System.out.println("En hilo: Comunico con: " + socket.toString());
				try {
					cadena = fentrada.readLine();
					//Si la cadena no es *, lo guardo en una lista
					if (!(cadena.trim().equals("*"))) {
						cadenas.add(cadena);
					}
				} catch (IOException e) {
					System.out.println("ERROR: el cliente se ha desconectado");
					parar = true;
				}
			}
			//una vez se escribe *, ordenamos la lista
			Collections.sort(cadenas);
			//Creamos la cadena que enviaremos separada por espacios
			String salida = "";
			for (String s : cadenas
			) {
				salida += s + " ";
			}
			//quito con trim el espacio sobrante del final
			salida = salida.trim();
			System.out.println(salida);

			//y lo enviamos al cliente
			fsalida.println(salida);

			//Comunico en el servidor que termino
			System.out.println("FIN CON " + socket.toString());

			// Cierro los flujos y el socket
			fsalida.close();
			try {
				fentrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}