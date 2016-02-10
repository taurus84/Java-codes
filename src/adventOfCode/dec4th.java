package adventOfCode;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class dec4th {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String secretKey = "iwrupvqb", md5hash, hashText;
		int counter = 1;
		MessageDigest m = MessageDigest.getInstance("MD5");
		do {
			md5hash = secretKey.concat(counter + "");
			m.reset();
			m.update(md5hash.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashText = bigInt.toString(16);
			counter++;
			System.out.println(hashText);
		} while(hashText.length() > 26);
		
		System.out.println(counter - 1);
	}
}
