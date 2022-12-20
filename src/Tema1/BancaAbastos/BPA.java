package Tema1.BancaAbastos;

public class BPA {
	public static void main(String[] args) {
		Compte compte = new Compte(40, 500);
		Persona persona1 = new Persona("Ivan", compte);
		Persona persona2 = new Persona("Manolo", compte);
		persona1.start();
		persona2.start();
	}
}
