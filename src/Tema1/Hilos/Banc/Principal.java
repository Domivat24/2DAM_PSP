package Tema1.Hilos.Banc;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static Scanner inNum = new Scanner(System.in);
	static Scanner inText = new Scanner(System.in);
	static ArrayList<Compte> comptes = new ArrayList<>();
	static TreureDiners h1;

	public static void main(String[] args) {

		int opcio = 0;
		while (opcio != 4) {
			opcio = menu(opcio);
		}
	}

	public static void donarAlta() {
		String nom;
		String nacionalitat;
		int edat, benef;
		ArrayList<Client> beneficiaris = new ArrayList<>();
		System.out.printf("Donarem d'alta el compte: " + Compte.getIdTotal());
		System.out.println("\nIntroduïsca nombre de beneficiaris:");
		try {
			benef = inNum.nextInt();
			for (int i = 0; i < benef; i++) {
				System.out.println("Introduïsca el nom del beneficiari " + (i + 1) + ":");
				nom = inText.nextLine();
				System.out.println("Introduïsca edat del beneficiari " + (i + 1) + ":");
				edat = inNum.nextInt();
				System.out.println(nom + " té nacionalitat espanyola (s/n)?");
				nacionalitat = inText.nextLine();
				beneficiaris.add(new Client(nom, edat, nacionalitat.charAt(0)));
			}
			comptes.add(new Compte(beneficiaris));
		} catch (Exception e) {
			//Limpiar el caché del scanner
			inNum.nextLine();
			donarAlta();
		}
	}

	public static void traureDiners() {
		int id = 0;
		boolean bucle;
		do {
			bucle= false;
			System.out.println("Introduïsca Aneu del comte d'on vol traure diners:");
			try {
				id = inNum.nextInt();
				if (id > Compte.getIdTotal() || id < 0) {
					throw new Exception();
				}
			} catch (Exception e) {
				bucle = true;
				System.out.println("El compte amb id " + id + " no existeix");
			}
			for (Client beneficiari : comptes.get(id-1).getBeneficiaris()) {
				h1 = new TreureDiners(comptes.get(id-1), beneficiari.getNom());
				h1.start();
			}
			try {
				h1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (bucle);
	}

	public static void resumCompte() {
		for (Compte compte : comptes) {
			System.out.printf("*** COMPTE: %d, ESTAT: %s, SALDO: %d €. ***\n+Beneficiaris:\n", compte.getId(), compte.getEstat(), compte.getSaldo());
			for (Client beneficiari : compte.getBeneficiaris()) {
				System.out.printf("\t-%s(%c), %d\n", beneficiari.getNom(), beneficiari.getNacionalitat(), beneficiari.getEdat());
			}
		}
	}

	public static int menu(int opcio) {
		System.out.println("1-Donar d'alta un compte\n2-Resum de comptes\n3-Traure diners d'un compte\n4-Eixir");
		opcio = inNum.nextInt();
		switch (opcio) {
			case 1:
				donarAlta();
				break;
			case 2:
				resumCompte();
				break;
			case 3:
				traureDiners();
				break;
			case 4:
				System.out.println("Gràcies, continue endeutant-se");
				break;
			default:
				return menu(opcio);
		}
		System.out.println("-------------------------");
		return opcio;
	}
}
