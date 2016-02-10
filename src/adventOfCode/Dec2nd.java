package adventOfCode;

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Dec2nd {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int area = 0;
		BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode/dec2nd.txt"));
		String s;
		while ((s = r.readLine()) != null) {
			String[] splitString = s.split("x");
			int area1 = Integer.parseInt(splitString[0]) * Integer.parseInt(splitString[1]);
			int area2 = Integer.parseInt(splitString[1]) * Integer.parseInt(splitString[2]);
			int area3 = Integer.parseInt(splitString[0]) * Integer.parseInt(splitString[2]);
			int smallest = area1;
			if (area2 < smallest)
				smallest = area2;
			if (area3 < smallest)
				smallest = area3;
			area += 2 * area1 + 2 * area2 + 2 * area3 + smallest;
		}
		System.out.println(area);

	}
}