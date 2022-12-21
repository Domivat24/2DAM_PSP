package Tema4.U4P1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Servidor {
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectOutputStream os = null;
	private ObjectInputStream is = null;

	public void comunica() {
		try {
			//ServerSocket esperando recibir conexion
			serverSocket = new ServerSocket(4445);
			System.out.println("Servidor en espera de connexió");
			socket = serverSocket.accept();
			System.out.println("Connectat");

			is = new ObjectInputStream(socket.getInputStream());
			System.out.println("Rebut");

			//recibido el objeto
			Persona persona = (Persona) is.readObject();
			System.out.println("Objecte rebut " + persona.getNom() + "-" + persona.getEdat());
			persona.setNom(persona.nom + " he estat al servidor");
			System.out.println("Objecte modificat Persona: " + persona.getNom() + "-" + persona.getEdat());

			//una vez modificado, lo vuelve a enviar
			os = new ObjectOutputStream(socket.getOutputStream());
			os.flush();
			os.writeObject(persona);
			System.out.println("Enviat");

			os.close();
			is.close();
			socket.close();

		} catch (SocketException e) {
			System.exit(0);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.comunica();
	}
}
