package adventOfCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec5th {

	
	
	public int nbrOfNiceStrings() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/adventOfCode/dec5th.txt"));
		int niceStrings = 0;
		String str;
		while ((str = br.readLine()) != null) {
				if(notAllowedContent(str) && vowels(str) && doubleLetter(str)) {
					niceStrings++;
				}
		}

		return niceStrings;
	}
	
	public boolean notAllowedContent(String str) {
		if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
			return false;
		}
		return true;
	}
	
	public boolean vowels(String str) {
		int counter = 0;
		char c;
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				counter++;
			}
			if(counter == 3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean doubleLetter(String str) {
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		Dec5th dc = new Dec5th();
		System.out.println(dc.nbrOfNiceStrings());
		
	}
}
