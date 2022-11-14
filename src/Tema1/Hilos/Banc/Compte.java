package Tema1.Hilos.Banc;

import java.util.ArrayList;

public class Compte {
	private static int id = 1;
	private ArrayList<Client> beneficiaris;
	private int saldo = 100;
	private boolean deute = false;

	public static int getId() {
		return id;
	}

	public Compte(ArrayList<Client> beneficiaris, int saldo, boolean deute) {
		this.beneficiaris = beneficiaris;
		this.saldo += saldo;
		this.deute = deute;
		id++;
	}
}
