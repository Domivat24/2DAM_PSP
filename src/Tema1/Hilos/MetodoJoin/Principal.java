package Tema1.Hilos.MetodoJoin;

public class Principal {
	public static void main(String[] args) {
		Hilo h1 = new Hilo("Hilo1", 3);
		Hilo h2 = new Hilo("Hilo2", 3);
		h1.start();
		h2.start();
		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			System.out.println("FIN DEL PROGRAMA");
		}
	}
}
