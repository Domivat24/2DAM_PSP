package Tema4.U4P1;

import java.io.Serializable;

public class Persona implements Serializable {
	String nom;
	int edat;

	private static final long serialVersionUID = 2L;

	public Persona(String nom, int edat) {
		this.nom = nom;
		this.edat = edat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}
}
