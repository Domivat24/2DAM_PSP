package Tema4.MulticastSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HostEmissor {
	final static String ADREÇA_INET = "224.0.0.3";
	final static int PORT = 8888;

	public static void main(String[] args) {
		try {
			InetAddress adreça = InetAddress.getByName(ADREÇA_INET);
			DatagramSocket serverSocket = new DatagramSocket();
			for (int i = 0; i < 5; i++) {
				String missatge = "--Missatge " + i + " del host emissor--";
				DatagramPacket datagrama = new DatagramPacket(missatge.getBytes(), missatge.getBytes().length, adreça, PORT);
				serverSocket.send(datagrama);

				System.out.println("Host emissor ha enviat datagrama amb el missatge: " + missatge);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
