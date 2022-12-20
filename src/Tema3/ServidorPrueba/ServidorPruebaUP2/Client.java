package Tema3.ServidorPrueba.ServidorPruebaUP2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	static final String HOST = "localhost";
	static final int PORT = 5000;

	public Client(String[] args) {
		try {
			final String HOST = args[0];
			Socket sCliente = new Socket(HOST, PORT);
			InputStream aux = sCliente.getInputStream();
			DataInputStream flux = new DataInputStream(aux);
			System.out.println(flux.readUTF());
			sCliente.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Client(args);
	}
}
