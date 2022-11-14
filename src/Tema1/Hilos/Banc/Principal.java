package Tema1.Hilos.Banc;

import java.util.Scanner;

public class Principal {
	static Scanner inNum = new Scanner(System.in);
	static Scanner inText = new Scanner(System.in);

	public static void main(String[] args) {
		int opcio = 0;
		while (opcio != 4) {
			opcio = menu(opcio);
		}
	}

	public static void donarAlta() {
		String nom;
		int edat, benef;
		System.out.printf("Donarem d'alta el compte: " + Compte.getId());
		System.out.println("Introduïsca nombre de beneficiaris:");
		try {
			benef = inNum.nextInt();
			for (int i = 0; i < benef; i++) {
				System.out.println("Introduïsca el nom del beneficiari " + i + ":");
				nom = inText.nextLine();
				System.out.println("Introduïsca edat del beneficiari " + i + ":");
				edat= inNum.nextInt();

			}
		} catch (Exception e) {
			donarAlta();
		}

	}

	public static int menu(int opcio) {
		System.out.println("1-Donar d'alta un compte\n2-Resum de comptes\n3-Traure diners d'un compte\n4-Eixir");
		switch (opcio) {
			case 1:
				donarAlta();
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				System.out.println("Gràcies, continue endeutant-se");
				break;
			default:
				return opcio = menu(opcio);
		}
		return opcio;
	}
}
