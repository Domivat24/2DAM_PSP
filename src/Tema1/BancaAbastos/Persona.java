package Tema1.BancaAbastos;

import java.util.Random;

public class Persona extends Thread {
	private Compte compte;


	public Persona(String nom, Compte compte) {
		super(nom);
		this.compte = compte;
	}

	public void run() {

		try {
			//Utilitze sleeps raere de cada execucio per a que la execucio siga mes de llegir,
			// pero son totalment opcionals per al funcionament del programa
			compte.ferIngres(getName());
			sleep(1000);
			compte.ferReintegrament(getName());
			sleep(1000);
			compte.ferIngres(getName());
			sleep(1000);
			compte.ferReintegrament(getName());
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
