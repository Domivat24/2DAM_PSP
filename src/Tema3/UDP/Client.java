package Tema3.UDP;

import java.io.IOException;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		DatagramSocket dScoket = null;

		if (args.length < 3) {
			System.out.println("Utilitzación: java Client <missatge> <nom del Host> <número de port>");
			try {
				dScoket = new DatagramSocket();
				byte[] missatgeEnviat = args[0].getBytes();
				InetAddress aHost = InetAddress.getByName(args[1]);
				int serverPort = Integer.valueOf(args[2]).intValue();
				DatagramPacket dpEnviament = new DatagramPacket(missatgeEnviat, args[0].length(), aHost, serverPort);
				dScoket.send(dpEnviament);
				byte[] missatgeRebut = new byte[1000];
				DatagramPacket dpResposta = new DatagramPacket(missatgeRebut,missatgeRebut.length);
				dScoket.receive(dpResposta);
				System.out.println("Resposta: "+ new String(dpResposta.getData()));
			} catch (SocketException e) {
				System.out.println("Socket: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO: " + e.getMessage());
			} finally {
				if (dScoket != null) {
					dScoket.close();
				}
			}
		}
	}
}
