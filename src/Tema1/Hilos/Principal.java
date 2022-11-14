package Tema1.Hilos;

public class Principal {
	public static void main(String[] args) {
		/*Hilo1 h = new Hilo1("Hilito1");
		h.start();
		Hilo1 hdos = new Hilo1("Hilazo2");
		hdos.start();*/

		ThreadGroup grupo = new ThreadGroup("Grupo de hilos");
		GrupoHilos h = new GrupoHilos();

		Thread h1 = new Thread(grupo, h, "Hilo1");
		Thread h2 = new Thread(grupo, h, "Hilo2");
		Thread h3 = new Thread(grupo, h, "Hilo3");
		h1.start();
		h2.start();
		h3.start();


	}
}
