package adventOfCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Uppgiften finns i filen dec5th_problem_answer
 * @author David
 *				2015-12-05
 */
public class Dec5thB {

	public int nbrOfNiceStrings() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/adventOfCode/dec5th.txt"));
		int niceStrings = 0;
		String str;
		while ((str = br.readLine()) != null) {
				if(repeatedLetterWithLetterBetween(str) && letterPairs(str)) {
					niceStrings++;
				}
		}

		return niceStrings;
	}
	
	public boolean repeatedLetterWithLetterBetween(String str) {

		for(int i = 0; i < str.length() - 2; i++) {
			if(str.charAt(i) == str.charAt(i + 2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean letterPairs(String str) {
		char a,b;
		for(int i = 0; i < str.length() - 3; i++) {
			a = str.charAt(i);
			b = str.charAt(i + 1);
			/*compare ab with letterPairs ahead*/
			for(int j = i+2; j < str.length() - 1; j++) {
				if(a == str.charAt(j) && b == str.charAt(j + 1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
//	ffumlmqwfcsyqpss
	
	

	public static void main(String[] args) throws IOException {

		Dec5thB dcb = new Dec5thB();
		System.out.println(dcb.nbrOfNiceStrings());
		
	}
}
