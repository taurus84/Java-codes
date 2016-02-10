package adventOfCode;

import java.io.*;

public class Dec2ndB {

	public static void main(String[] args) throws java.lang.Exception {
		int ribbon = 0;
		BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode/dec2nd.txt"));
		String s;
		while ((s = r.readLine()) != null) {
			String[] splitString = s.split("x");
			int side1 = Integer.parseInt(splitString[0]);
			int side2 = Integer.parseInt(splitString[1]);
			int side3 = Integer.parseInt(splitString[2]);
			int biggestSide = side1;
			if (side2 > biggestSide)
				biggestSide = side2;
			if (side3 > biggestSide) {
				biggestSide = side3;
				ribbon += 2 * (side1 + side2);
			} else if (side1 >= side2) {
				ribbon += 2 * (side3 + side2);
			} else {
				ribbon += 2 * (side1 + side3);
			}
			ribbon += side1 * side2 * side3;
		}
		System.out.println(ribbon);
	}
}
