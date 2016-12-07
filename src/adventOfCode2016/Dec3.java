package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Dec3 {
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec3.txt"));
	        String s;
	        int[] sides = new int[3];
	        int nbrOfTriangles = 0;
	        while ((s = r.readLine()) != null) {
	        	sides = getNumbers(s);
				Arrays.sort(sides);
				if((sides[0] + sides[1]) > sides[2]) {
					nbrOfTriangles++;
				}
			}
	        System.out.println(nbrOfTriangles);
	 }
	 
	 public static int[] getNumbers(String str) {
		 int[] numbers = new int[3];
		 String[] splitString = str.split("\\s+");
		 numbers[0] = Integer.parseInt(splitString[1]);
		 numbers[1] = Integer.parseInt(splitString[2]);
		 numbers[2] = Integer.parseInt(splitString[3]);
		 
		 return numbers;
	 }
	 
	 

}
