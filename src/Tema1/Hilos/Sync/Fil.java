package Tema1.Hilos.Sync;

public class Fil extends Thread {
	private ObjetoCompartido objeto;
	String cad;

	public void run() {
		synchronized (objeto) {
			for (int i = 0; i < 10; i++) {
				objeto.PintaCadena(cad);
				objeto.notify();
				try {
					objeto.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public Fil(ObjetoCompartido c, String s) {
		this.objeto = c;
		this.cad = s;
	}
}
