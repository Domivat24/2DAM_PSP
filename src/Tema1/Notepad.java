package Tema1;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Notepad {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		//"Notepad"
		String comando = "CMD /C cd && cd Downloads && dir";
		Process p= null;
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linia;
			linia = br.readLine();
			while (linia != null) {
				System.out.println(linia);
				linia = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error en " + comando);
			e.printStackTrace();
		}
		int exitV;
		try {
			exitV = p.waitFor();
			System.out.println("Valor de salida "+exitV);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
