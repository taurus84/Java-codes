package adventOfCode2016;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Dec5b {

	private static int counter8 = 0;
	private static char[] password = new char[8];
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
		
		for(int i = 0; i < 8; i++) {
			System.out.print(password[i]);
		}
		
		
	}
	
	public static boolean checkHash(String hash) {
		int counter = 0;
		if(hash.charAt(0) == '0' &&
				hash.charAt(1) == '0' &&
				hash.charAt(2) == '0' &&
				hash.charAt(3) == '0' &&
				hash.charAt(4) == '0') {
			char c = hash.charAt(5);
			int pos = Character.valueOf(c)-48;
			if(pos < 8) {
				
				password[pos] = hash.charAt(6);
				System.out.println("Found letter: " + hash.charAt(6) + " goes into position: " + pos);
				for(int i = 0; i < 8; i++) {
					if(password[i] == '\u0000') {
						counter++;
					}
				}
				
//				counter8++;
			}
			if(counter == 0) return false;
		}
		return true;
	}
}
