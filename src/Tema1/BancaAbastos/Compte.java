package Tema1.BancaAbastos;

import java.util.Random;

public class Compte {
	private int max_saldo, saldo;

	public Compte(int saldo, int max_saldo) {
		this.max_saldo = max_saldo;
		this.saldo = saldo;
	}

	public synchronized void ferIngres(String nom) {
		Random rnd = new Random();
		//me vaig donar conter que diners = (int) (rnd.nextDouble() * 501) podía eixr 0, aixina que he trobat altra alternativa diferent que si que dona realmeent del 1 al 500
		int diners = rnd.ints(1, 501).findAny().getAsInt();
		try {
			//bucle per a asegurarme que una vegada el thread rep el notify, el saldo ha canviat lo suficient per a fer el calcul esperat;
			// si no es així, es quedarà esperant
			while (diners + saldo > max_saldo) {
				System.out.printf("%s vol ingressar %d diners. Massa saldo. Saldo actual: %d\n", nom, diners, saldo);
				wait();
			}

			System.out.println("Es va a ingressar saldo (el saldo actual és: " + saldo + ")");
			saldo += diners;
			System.out.printf("%s ingressa => : %d. Saldo actual: %d\n", nom, diners, saldo);
			//me asegure de que tota persona intentant fer la operación en el conter, en cas de que hi haguera mes de una
			// persona esperant, puga retomar la operació i comprovar de nou si ARA pot o no realitzarla
			notifyAll();


		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void ferReintegrament(String nom) {
		//genero el numero aleaotrio en los métodos para así no generar líneas de más en el run() de persona
		Random rnd = new Random();
		int diners = (int) (rnd.nextDouble() * 501.0);
		try {
			//bucle per a asegurarme que una vegada el thread rep el notify, el saldo ha canviat lo suficient per a fer el calcul esperat;
			// si no es així, es quedarà esperant
			while (saldo - diners < 0) {
				System.out.printf("%s vol retirar %d diners però no hi ha prou saldo. Saldo actual: %d\n", nom, diners, saldo);
				wait();
			}
			System.out.println("Es va a retirar diners (el saldo actual és: " + saldo + ")");
			saldo -= diners;
			System.out.printf("%s retira => : %d. Saldo actual: %d\n", nom, diners, saldo);
			//me asegure de que tota persona intentant fer la operación en el conter, en cas de que hi haguera mes de una
			// persona esperant, puga retomar la operació i comprovar de nou si ARA pot o no realitzarla
			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getSaldo() {
		return saldo;
	}
}
