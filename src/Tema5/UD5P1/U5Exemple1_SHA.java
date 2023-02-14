package Tema5.UD5P1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class U5Exemple1_SHA {
	public static void main(String[] args) {
		String text = "Sóc el contingut d'un text";
		System.out.println("Text origen per a hash " + text);

		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			String clave = "ClauXifratge";
			byte dataBytes[] = text.getBytes();
			md.update(dataBytes);
			byte resum_amb_clau[] = md.digest(clave.getBytes());

			md.update(text.getBytes());

			byte resum[] = md.digest();

			System.out.println("Nombre de bytes " + md.getDigestLength());
			System.out.println("Algorisme " + md.getAlgorithm());
			System.out.println("Missatge resum " + resum_amb_clau + new String(resum));

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < resum.length; i++) {
				String hex = Integer.toHexString(0xff & resum[i]);
				if (hex.length() == 1) {
					hexString.append('0');
					hexString.append(hex);
				}
			}
			System.out.println("Missatge en hexadecimal : " + hexString);
			Provider proveedor = md.getProvider();
			System.out.println("Proveidor " + proveedor.toString());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}