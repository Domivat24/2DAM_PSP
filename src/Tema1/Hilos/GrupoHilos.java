package Tema1.Hilos;

public class GrupoHilos extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().toString());
	}
}
