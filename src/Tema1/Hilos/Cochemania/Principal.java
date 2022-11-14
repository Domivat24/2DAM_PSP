package Tema1.Hilos.Cochemania;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static Scanner inNum = new Scanner(System.in);
	static Scanner inText = new Scanner(System.in);

	public static int pedirNum() {
		int entrada;
		try {
			entrada = inNum.nextInt();
		} catch (Exception e) {
			System.out.println("Per favor, introdueix un número.");
			entrada = pedirNum();
		}
		return entrada;

	}

	public static void main(String[] args) {
		int totalCotxes;
		System.out.println("Introdueix número de cotxes");
		ArrayList<Cotxe> listaCotxes = new ArrayList<>();
		totalCotxes = pedirNum();
		String marca;
		for (int i = 0; i < totalCotxes; i++) {
			System.out.printf("Introdueix marca del cotxe %d\n", i + 1);
			marca = inText.nextLine();
			listaCotxes.add(new Cotxe(marca));
		}
		System.out.println("Que començe la carrera!");
		for (Cotxe c : listaCotxes) {
			c.start();
		}
	}
}
