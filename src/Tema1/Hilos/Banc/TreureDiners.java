package Tema1.Hilos.Banc;

public class TreureDiners extends Thread {
	Compte compte;
	String nombre;

	public TreureDiners(Compte compte, String n) {
		this.compte = compte;
		this.nombre = n;
	}

	public void run() {
		for(int i=0; i<3 ; i++) {
			compte.retirarDinero(10,nombre);
		}
	}
}
