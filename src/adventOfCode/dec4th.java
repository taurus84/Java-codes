package adventOfCode;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class dec4th {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String secretKey = "abc", md5hash, hashText;
		int counter = 1;
		MessageDigest m = MessageDigest.getInstance("MD5");
		do {
			md5hash = secretKey.concat(counter + "");
			m.reset();
			m.update(secretKey.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashText = bigInt.toString(16);
			counter++;
			System.out.println(hashText);
		} while(checkHash(hashText));
		
		System.out.println(counter - 1);
	}
	
	public static boolean checkHash(String hash) {
		if(hash.charAt(0) == '0' &&
				hash.charAt(1) == '0' &&
				hash.charAt(2) == '0' &&
				hash.charAt(3) == '0' &&
				hash.charAt(4) == '0')
			return true;
		
		return false;
	}
}
