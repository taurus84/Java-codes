package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec6b {
	static int[][] charArray = new int[26][8];
	 public static void main(String[] args) throws IOException {
		 BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec6.txt"));
	        String s;
	        
	        while ((s = r.readLine()) != null) {
	        	for(int i = 0; i < s.length(); i++) {
	        		charArray[s.charAt(i) - 97][i]++;
	        	}
	        }
	        
			 for(int k = 0; k < 8; k ++) {
				 int smallestIndex = 0, smallestValue = 10000;
				 for(int i = 0; i < 26; i++) {
					 	if(charArray[i][k] < smallestValue) {
					 		smallestIndex = i;
					 		smallestValue = charArray[i][k];
					 	}
				 }
				 System.out.println("Character at col: " + k + " is " 
						 + new Character((char) (smallestIndex + 97)));
			 }
	        
	 }
	 

}
