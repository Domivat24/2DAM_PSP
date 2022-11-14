package Tema1.Hilos.Exercici31;

public class Filresta extends Thread {
	private Comptador comptador;
	private int cantidad;

	public Filresta(String n, Comptador c, int cantidad) {
		super(n);
		comptador = c;
		this.cantidad = cantidad;
	}

	public void run() {
		synchronized(comptador) {
			for (int j=0; j < cantidad; j++) {
				comptador.res();
				try {
					sleep(1000);
				}catch(InterruptedException e) {}
				System.out.println(getName() + " comptador val " + comptador.getCon());
			}
		}//synchronized
	}
}
