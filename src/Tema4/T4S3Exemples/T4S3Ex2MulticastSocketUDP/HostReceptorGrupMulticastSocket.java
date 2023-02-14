package Tema4.T4S3Exemples.T4S3Ex2MulticastSocketUDP;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.util.Random;

public class HostReceptorGrupMulticastSocket {
	final static String ADREÇA_INET = "224.0.0.6";
	final static int PORT = 8888;

	public static void main(String[] args) {
		try {
			Random aleatori = new Random();
			int num = (int) (aleatori.nextDouble() * 100 + 1);
			System.out.println("Inici host receptor " + num);

			InetAddress adreça = InetAddress.getByName(ADREÇA_INET);
			InetSocketAddress grup = new InetSocketAddress(adreça, PORT);
			byte[] mis = new byte[256];
			//S'unim al grup multicast UDP, dona igual ser el primer o no
			MulticastSocket clientSocket = new MulticastSocket(PORT);
			clientSocket.joinGroup(grup, null);
			System.out.println("Host receptor s'ha unit al grup" + adreça);

			System.out.println("Inici recepció paquets");
			while (true) {
				DatagramPacket msgPacket = new DatagramPacket(mis, mis.length);
				clientSocket.receive(msgPacket);

				String msg = new String(mis, 0, mis.length);
				System.out.println("Missatge rebut: " + msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
