package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec7 {
	
	public static void main(String[] args) throws IOException {

		 BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec7.txt"));
		 String s;
		 int counter = 0;
		 /* för varje [ finns en ] */
		 while((s = r.readLine()) != null) {
			 boolean noAbbasInBrackets = true, abbaOutsideBracket = false;
			 String[] splitString = s.split("\\[");
			 if(abba(splitString[0])) abbaOutsideBracket = true;
			 for(int i = 1; i < splitString.length; i++) {
				 String[] split2 = splitString[i].split("\\]");
				 if(abba(split2[0])) {
					 noAbbasInBrackets = false;
					 break;
				 } else {
					 if(abba(split2[1])) {
						 abbaOutsideBracket = true;
					 }
				 }
			 }
			 if(abbaOutsideBracket && noAbbasInBrackets) 
				 counter++;
		 }
		 System.out.println(counter);
	        
	}
	
	public static boolean abba(String str) {
		for(int i = 2; i < str.length() -1; i++) {
			char c = str.charAt(i), b = str.charAt(i-1),
					a = str.charAt(i-2), d = str.charAt(i+1);
			if(b == c && a == d && b != a) return true;
		}
		return false;
	}
}
