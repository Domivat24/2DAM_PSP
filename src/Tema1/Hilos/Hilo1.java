package Tema1.Hilos;

public class Hilo1 extends Thread{
	public Hilo1(String name) {
		super(name);
	}

	public void run() {
		System.out.println("Creando esta... "+ getName());
	}
}
