package Tema5.UD5P1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class U5Exemple2_SHA {
	public static void main(String[] args) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
