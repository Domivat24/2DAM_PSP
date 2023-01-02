package Tema3.Ramonix;

import java.util.ArrayList;

public class Principal implements Comu {

	public static void main(String[] args) {
		/*
		COSES QUE CAL FER:
		-Crear la sala de reunions per a esperar que arriben tots
		-Crear els 4 hackers -fils- (Neo, P4Qu1T0, Pa13T i Ab4$T0$)
		-Llen�ar els atacs
		*/
		
		ArrayList<Hacker> llista_hackers = new ArrayList<Hacker>();
		
		//Creem la sala de reunions que es compartida per tots els hackers.
		//S'ha de fer ac� i passar-la com a par�metre perqu� �s compartida per tots els fils.
		SalaReunions salaReunions=new SalaReunions();
		
		//-Crear els 4 hackers -fils- (Neo, P4Qu1T0, PaU3T i Ab4$T0$)
		for (int i=0; i < HACKERS.length; i++) {
			System.out.println("Cree: "+HACKERS[i]);
			Hacker h = new Hacker(HACKERS[i], salaReunions);
			llista_hackers.add(h);
		}
		
		//-Llen�ar els fils (i atacs)
		for (int i=0; i < HACKERS.length; i++)
			llista_hackers.get(i).start();
	}
}
