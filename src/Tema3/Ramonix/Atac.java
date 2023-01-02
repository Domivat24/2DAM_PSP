package Tema3.Ramonix;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;


public class Atac implements Comu {


	//boolean que se encarrega de detindre
	static volatile boolean ramonixMor = false;

	static DatagramSocket dSocket = null;
	static DatagramPacket dpEnviament = null;

	public static void atac(String hacker, int damage, boolean enemy) {

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
		} catch (Exception e) {
			//no mostra per pantalla res
		} finally {
			if (dSocket != null) {
				dSocket.close();
			}
		}
	}


	//Teoricament este metode deuria esperar a rebre un packet informant que ramonix mor:
	//si no hi rep res, es produeix una excepcio que atrape, aixina "TEORICAMENT", sols arribara a les dues ultimes linies quan rep el packet de que Ramonix ha mort.
	// I per lo tant, al tornar true, la variable volatil deuria ser capaç de fer parar a la resta de fils.
	// Pero he intentat de tot, definint i cridant setters normals i corrents desde les classes Atac, Ramonix i Hacker; sincronitzar distints metodes
	// de comprovació de que Ramonix havia mort; utilitzar AtomicBoolean(per a donarme conter que actualitzaro atomicament es just lo que no necessitava,
	// ja que sí que parava els fils, pero fins que no fera el update atomiacment no entrava en altre fil)

	public static boolean ramonixViu() {
		DatagramPacket dpResposta = null;
		try {
			dSocket = new DatagramSocket(PORT);
			byte[] missatgeRebut = new byte[1000];
			dpResposta = new DatagramPacket(missatgeRebut, missatgeRebut.length);
			dSocket.receive(dpResposta);

		} catch (IOException e) {
			return ramonixMor;
		} finally {
			if (dSocket != null) {
				dSocket.close();
			}
		}
		//deuria arribar en rebre la resposta i definir la variable local ramonixMor com a true per a que, si magicament entrara algun altre fil, tornara true
		ramonixMor = true;
		return true;
	}
}