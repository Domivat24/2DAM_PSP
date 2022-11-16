package Tema1.Hilos.Banc;

public class Client {
	private String nom;
	private int edat;
	private char nacionalitat;

	public String getNom() {
		return nom;
	}

	public int getEdat() {
		return edat;
	}

	public char getNacionalitat() {
		return nacionalitat;
	}

	public Client(String nom, int edat, char nacionalitat) {
		this.nom = nom;
		this.edat = edat;
		this.nacionalitat = nacionalitat;
	}
}
