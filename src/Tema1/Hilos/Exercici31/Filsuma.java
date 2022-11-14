package Tema1.Hilos.Exercici31;

public class Filsuma extends Thread {
	int cantidad;
	private Comptador comptador;

	public Filsuma(String n, Comptador c, int cantidad) {
		super(n);
		comptador = c;
		this.cantidad = cantidad;
	}

	public void run() {
		synchronized (comptador) {
			for (int i = 0; i < cantidad; i++) {
				comptador.sum();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Filsuma comptador val " + comptador.getCon());
			}
		}
	}
}
