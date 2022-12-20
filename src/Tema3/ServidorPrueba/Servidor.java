package Tema3.ServidorPrueba;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static final int PORT = 5000;

	public Servidor() {
		try {
			ServerSocket ssServidor = new ServerSocket(PORT);
			System.out.println("Escolte al port " + PORT);
			for (int numCli = 0; numCli < 3; numCli++) {
				Socket sCliente = ssServidor.accept();
				System.out.println("Servisc al client");
				OutputStream aux = sCliente.getOutputStream();
				DataOutputStream flux = new DataOutputStream(aux);
				flux.writeUTF("Hola cacho de puto");
				sCliente.close();
			}
			System.out.println("Massa puto per hui");
			ssServidor.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}
}
