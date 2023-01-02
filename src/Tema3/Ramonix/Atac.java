package Tema3.Ramonix;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;


public class Atac implements Comu {


	//boolean que se encarrega de detindre
	static boolean ramonixMor = false;
	static DatagramSocket dSocket = null;
	static DatagramPacket dpEnviament = null;

	public static void setRamonixMor(boolean ramonixMor) {
		Atac.ramonixMor = ramonixMor;
	}

	public static void atac(String hacker, int damage, boolean enemy) {
		//si ramonix ha mort, no es seguira atacant
		if (!ramonixMor) {

			//separador entre el hacker i el daño del DatagramPacket que sera enviat, indicant si sera sumat o restat
			String accion = "-";
			try {
				dSocket = new DatagramSocket();
				// si es un enemic, se sumarà el daño
				if (enemy) {
					accion = "_";
				}
				byte[] missatgeEnviat = (hacker + accion + damage).getBytes();
				dpEnviament = new DatagramPacket(missatgeEnviat, missatgeEnviat.length, InetAddress.getByName(HOST), PORT);
				dSocket.send(dpEnviament);
				//mostre per pantalla, una vegada se ha enviat, qui esta atacant amb colors
				switch (hacker) {
					case "Neo":
						System.out.println(ANSI_RED + hacker + " atacant...");
						break;
					case "PaU3T":
					case "P4q1T0":
						System.out.println(ANSI_YELLOW + hacker + " atacant...");
						break;
					case "Ab4$t0$":
						System.out.println(ANSI_GREEN + hacker + " atacant...");
						break;
				}
			} catch (SocketException e) {
				System.out.println("Ramonix: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO: " + e.getMessage());
			} finally {
				if (dSocket != null) {
					dSocket.close();
				}
			}
		}
	}

	//teoricament este metode deuria esperar a rebre un packet informant que ramonix mor,
	// i per lo tant pot definir la variable ramonixMor com a true, per a que la resta de fils no continuen atacant,
	// pero entra igualemnte al catch, o a saber que pasa, pero no puc comprobaro perque no em dixa debuguearo
	//PD: tinc un setter que deuria fer lo mateix, cridate desde Ramonix.java pero tampoc fa res
	public static boolean ramonixViu() {


		DatagramPacket dpResposta = null;
		try {
			dSocket = new DatagramSocket(PORT);
			byte[] missatgeRebut = new byte[1000];
			dpResposta = new DatagramPacket(missatgeRebut, missatgeRebut.length);
			dSocket.receive(dpResposta);

		} catch (IOException e) {
			if (ramonixMor) {
				return false;
			}
			return true;
		} finally {
			if (dSocket != null) {
				dSocket.close();
			}
		}
		ramonixMor = true;
		return false;
	}
}