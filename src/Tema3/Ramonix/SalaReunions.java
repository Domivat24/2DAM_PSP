package Tema3.Ramonix;

public class SalaReunions implements Comu {
	boolean neoReady = false;
	int hackersReady = 0;

	public int getHackersReady() {
		return hackersReady;
	}

	public void setNeoReady() {
		neoReady = true;
		System.out.println("****** Neo-: Bon dia. anem a destruir RAMONIX! ******");
		hackersReady++;
	}

	public void addReadyHacker(String Hacker) {
		System.out.println(Hacker + "-: Bon dia Neo...");
		hackersReady++;
	}

	public boolean isNeoReady() {
		return neoReady;
	}
}
