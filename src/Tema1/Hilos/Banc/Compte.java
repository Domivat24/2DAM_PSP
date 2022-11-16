package Tema1.Hilos.Banc;

import java.util.ArrayList;

public class Compte {
	private static int idTotal = 1;
	private int id;
	private ArrayList<Client> beneficiaris;
	private int saldo = 100;
	private boolean deute = false;

	public synchronized void retirarDinero(int cantidad, String nombre) {
		if (getSaldo() >= cantidad) {
			System.out.println(nombre + ": ES VA A RETIRAR SALDO. (Actual es: " + getSaldo() + "€).");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			saldo -= cantidad;
			System.out.println("\t" + nombre + " retira " + cantidad + "€. Saldo actualitzat es: (" + getSaldo() + " €).");
		} else {
			System.out.println(nombre + " no pot retirar diners. No hi ha saldo (" + getSaldo() + " €.)");
		}

		if (getSaldo() < 0) {
			System.out.println("Saldo negatiu=>" + getSaldo());
			deute = true;
		}

	}

	public int getId() {
		return id;
	}

	public static int getIdTotal() {
		return idTotal;
	}

	public Compte(ArrayList<Client> beneficiaris, int saldo, boolean deute) {
		this.beneficiaris = beneficiaris;
		this.saldo += saldo;
		this.deute = deute;
		id = idTotal;
		idTotal++;
	}

	public Compte(ArrayList<Client> beneficiaris) {
		this.beneficiaris = beneficiaris;
		id = idTotal;
		idTotal++;
	}

	public int getSaldo() {
		return saldo;
	}

	public ArrayList<Client> getBeneficiaris() {
		return beneficiaris;
	}

	public String getEstat() {
		if (saldo >= 0) {
			deute = false;
			return "ACTIVA";
		}
		deute = true;
		return "DEUTORA";
	}
}
