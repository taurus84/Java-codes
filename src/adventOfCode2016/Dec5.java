package adventOfCode2016;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Dec5 {

	private static int counter8 = 0;
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String doorID = "cxdnnyjw", md5hash, hashText;
		int counter = 0;
		MessageDigest m = MessageDigest.getInstance("MD5");
		do {
			md5hash = doorID.concat(counter + "");
//			System.out.println(md5hash);
			m.reset();
			m.update(md5hash.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashText = bigInt.toString(16);
			while (hashText.length() < 32) {
				hashText = "0"+hashText;
			}
			counter++;
		} while(checkHash(hashText));
		
		
	}
	
	public static boolean checkHash(String hash) {
		if(hash.charAt(0) == '0' &&
				hash.charAt(1) == '0' &&
				hash.charAt(2) == '0' &&
				hash.charAt(3) == '0' &&
				hash.charAt(4) == '0') {
			System.out.print(hash.charAt(5));
			counter8++;
			if(counter8 == 8) return false;
		}
			
		
		return true;
	}
}
