package Tema1.Hilos.Sync;

public class Main {

	public static void main(String[] args) {
		ObjetoCompartido com = new ObjetoCompartido();
		Fil a = new Fil(com, " A ");
		Fil b = new Fil(com, " B ");
		a.start();
		b.start();

	}

}
