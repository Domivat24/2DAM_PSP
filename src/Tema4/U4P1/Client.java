package Tema4.U4P1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	private Socket socket = null;
	private ObjectOutputStream os = null;
	private ObjectInputStream is = null;
	private boolean estaConnectat = false;

	public Client() {
	}

	public void comunicate() {
		while (!estaConnectat) {
			try {
				socket = new Socket("localhost", 4445);
				System.out.println("Connectat");
				estaConnectat = true;
				os = new ObjectOutputStream(socket.getOutputStream());

				Persona persona = new Persona("Pepe", 25);
				System.out.println("Objecte a enviar: " + persona.getNom() + "-" + persona.getEdat());
				os.flush();
				os.writeObject(persona);

				is = new ObjectInputStream(socket.getInputStream());
				System.out.println("Rebut");

				//recibido el objeto
				persona = (Persona) is.readObject();

				System.out.println("Objecte rebut: " + persona.getNom() + "-" + persona.getEdat());
				is.close();
				os.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.comunicate();
	}
}
