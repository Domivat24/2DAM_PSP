package Tema1.Hilos.Ejercicio11;

public class Main {
	public static void main(String[] args) {
		Fil f = new Fil("1");
		Fil f1 = new Fil("2");
		Fil f2 = new Fil("3");
		f.start();
		f1.start();
		f2.start();


	}
}
