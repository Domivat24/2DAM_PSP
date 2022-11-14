package Tema1.Hilos.MetodoJoin;

public class Hilo extends Thread {
	private int n;

	public Hilo(String nom, int n) {
		super(nom);
		this.n = n;
	}

	public void run() {
		for (int i = 1; i <= n; i++) {
			System.out.println(getName() + ":" + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin bucle " + getName());
	}
}
