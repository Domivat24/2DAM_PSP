package Tema1.Hilos.Exercici31;

public class Comptador {
	public Comptador(int con) {
		this.con = con;
	}

	int con;

	public void sum() {
		con++;
	}

	public void res() {
		con--;
	}

	public int getCon() {
		return con;
	}
}
