package Tema3.Ramonix;

public class Hacker extends Thread implements Comu {
	String hacker;
	static volatile boolean ramonixMor = false;
	final SalaReunions salaReunions;
	int time = 1, damage = 10;
	boolean enemy = false;

	public Hacker(String hacker, SalaReunions salaReunions) {
		this.hacker = hacker;
		this.salaReunions = salaReunions;
	}

	public static void RamonixHaMort() {
		ramonixMor = true;
	}

	public void run() {
		try {
			synchronized (salaReunions) {
				//entra neo
				if (hacker.equals("Neo")) {
					time = 2;
					damage = 20;
					salaReunions.setNeoReady();
					//si algu es troba esperant, el desperta, ja que Neo ja esta preparat
					salaReunions.notifyAll();
				} else {
					//si neo no esta preparat, el resto esperen a iniciar la reunio
					if (!salaReunions.isNeoReady()) {
						salaReunions.wait();
					}
					salaReunions.addReadyHacker(hacker);
				}
				//si no estan tots preparats, espera
				if (salaReunions.getHackersReady() != HACKERS.length) {
					salaReunions.wait();
				} else {
					//si estan tots, avise al resto que ja poden atacar
					salaReunions.notifyAll();
				}
			}
			//eixim de la sala de reunions i comencen els atacs
			System.out.println("JA ESTEM TOTS. " + hacker + " COMENÇA L'ATAC!!!");
			//si el hacker es abastos, sera enemic i curara a Ramonix
			if (hacker.equals("Ab4$t0$")) {
				enemy = true;
			}
			//atacaran, teoricament, mentres Ramonix siga viu
			while (!ramonixMor) {
				Atac.atac(hacker, damage, enemy);
				sleep(time * 1000L);
				if (Atac.ramonixViu()) {
					ramonixMor = true;
				}
			}
			//Com a bon lider, una vegada terminen amb Ramonix, Neo comunica que ha caigut
			if (hacker.equals("Neo")) {
				System.out.println(ANSI_CYAN + "RAMONIX TANGO DOWN" + ANSI_RESET);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
