package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Dec3b {
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec3.txt"));
	        String s;
	        int[] possibleTriangle1 = new int[3];
	        int[] possibleTriangle2 = new int[3];
	        int[] possibleTriangle3 = new int[3];
	        int nbrOfTriangles = 0, counter = 0;
	        while ((s = r.readLine()) != null) {
	        	possibleTriangle1[counter] = getNumbers(s)[0];
	        	possibleTriangle2[counter] = getNumbers(s)[1];
	        	possibleTriangle3[counter] = getNumbers(s)[2];
				counter++;
				if(counter == 3) {
					Arrays.sort(possibleTriangle1);
					Arrays.sort(possibleTriangle2);
					Arrays.sort(possibleTriangle3);
					if((possibleTriangle1[0] + possibleTriangle1[1]) > possibleTriangle1[2])
						nbrOfTriangles++;
					if((possibleTriangle2[0] + possibleTriangle2[1]) > possibleTriangle2[2])
						nbrOfTriangles++;
					if((possibleTriangle3[0] + possibleTriangle3[1]) > possibleTriangle3[2])
						nbrOfTriangles++;
					
					counter = 0;
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
