package Tema1.Hilos.Cochemania;

public class Cotxe extends Thread {
	static int con_Cotxe = 0;
	private int n_Cotxe;
	private String marca;

	public Cotxe(String marca) {
		this.marca = marca;
		con_Cotxe++;
		n_Cotxe = con_Cotxe;
	}

	public void run() {
		int speed;
		int distancia = 0;
		final int meta = 500;
		for (; distancia < meta; distancia += speed) {
			speed = (int) (Math.random() * 100);
			System.out.printf("%s ha recorregut %d km!\n", this.toString(), distancia);
		}
		System.out.printf("El cotxe %s ha finalitzat al recorrer %d km\n", this, distancia);
	}

	@Override
	public String toString() {
		return String.format("%s(%d)", marca, n_Cotxe);
	}
}
