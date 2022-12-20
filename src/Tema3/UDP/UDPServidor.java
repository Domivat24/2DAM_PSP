package Tema3.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServidor {
	public static void main(String[] args) {
		DatagramSocket dSocket = null;
		if (args.length < 1) {
			System.out.println("Uso: java UDPServer <poneme aca el puerto boludo>");
			System.exit(1);
		}
		try {
			int socket_no = Integer.valueOf(args[0]).intValue();
			dSocket = new DatagramSocket(socket_no);
			byte[] missatgeRebut = new byte[1000];

			while (true) {
				DatagramPacket dpRebut = new DatagramPacket(missatgeRebut, missatgeRebut.length);
				dSocket.receive(dpRebut);
				System.out.println("Rep del client: " + new String(dpRebut.getData()));


				DatagramPacket dpResposta = new DatagramPacket(dpRebut.getData(), dpRebut.getLength(), dpRebut.getAddress(), dpRebut.getPort());
				dSocket.send(dpResposta);

			}
		} catch (SocketException e) {
			System.out.println("Socket " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (dSocket != null) {
				dSocket.close();
			}
		}
	}
}
