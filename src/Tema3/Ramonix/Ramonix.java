package Tema3.Ramonix;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Ramonix implements Comu {
	static int comptador = 500;


	public static void main(String[] args) {
		DatagramPacket dpResposta = null;

		DatagramSocket dScoket = null;
		String hacker = "";
		String[] resp;
		System.out.println("Benvinguts a RAMONIX!\n");
		try {
			dScoket = new DatagramSocket(PORT);
			while (comptador > 0) {
				byte[] missatgeRebut = new byte[1000];
				dpResposta = new DatagramPacket(missatgeRebut, missatgeRebut.length);
				dScoket.receive(dpResposta);
				//rep els datos i m'asegure de si he de sumar o restar la quantitat
				if (new String(dpResposta.getData()).contains("_")) {
					resp = new String(dpResposta.getData(), StandardCharsets.UTF_8).split("_");
					hacker = resp[0];
					//amb el trim elimine tot el espai resultant del DatagramPacket, que intereferiria en l'hora de pasaro a enter per fer el calcul
					comptador += Integer.parseInt(resp[1].trim());
				} else {
					resp = new String(dpResposta.getData()).split("-");
					hacker = resp[0];
					comptador -= Integer.parseInt(resp[1].trim());
				}
				switch (hacker) {
					case "Neo":
						System.out.println(ANSI_RED + "Atac des de: " + hacker);
						break;
					case "PaU3T":
					case "P4q1T0":
						System.out.println(ANSI_YELLOW + "Atac des de: " + hacker);
						break;
					case "Ab4$t0$":
						System.out.println(ANSI_GREEN + "Atac des de: " + hacker);
						break;

				}
				System.out.println(ANSI_RESET + "**** Energia: " + comptador);
			}
			System.out.println("COMUNIQUE AL CLIENT QUE TANQUE");
			byte[] missatgeEnviat = ("He terminat").getBytes();
			DatagramPacket dpEnviament = new DatagramPacket(missatgeEnviat, missatgeEnviat.length, dpResposta.getAddress(), PORT);
			dScoket.send(dpEnviament);


		} catch (Exception e) {
			System.out.println("Ramonix : " + e.getMessage());
		} finally {
			if (dScoket != null) {
				dScoket.close();
			}
		}

	}
}
