package Tema1.Hilos.Ejercicio11;

public class Fil extends Thread {
	public Fil(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.printf("Fil %s amb valor = %d\n", getName(), i);
		}
	}
}
