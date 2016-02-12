package knattra;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Uppgift6 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String result = "", md5hash, hashText;
		int counter = 0;
		MessageDigest m = MessageDigest.getInstance("MD5");

		do {
			StringBuilder s = new StringBuilder();
			md5hash = Integer.toString(counter);
			m.reset();
			m.update(md5hash.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashText = bigInt.toString(16);

			for (int i = 0; i < hashText.length(); i++) {
				if (hashText.charAt(i) >= 97 && hashText.charAt(i) <= 101) {
					s.append(hashText.charAt(i));
				}
			}
			counter++;
			result = s.toString();

		} while (!result.contains("aaabccddee"));

		System.out.println(result);
		System.out.println(hashText);
		System.out.println(counter - 1);

	}
}
