package ExamenMultiHilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String args[]) throws IOException {
		//Creo el servidor
		ServerSocket servidor;
		servidor = new ServerSocket(60000);
		System.out.println("Inicio Servidor en 60000");

		//El servidor siempre esuchará hasta que este no se cierre
		while (true) {
			Socket socketClient = new Socket();
			//Espera al cliente
			socketClient = servidor.accept();
			//El hilo se asocia al cliente y lo atiende
			FilServidor hilo = new FilServidor(socketClient);

			//y se inicia el hilo
			hilo.start();
			System.out.println("Inicio hiloservidor");
		}

	}
}
