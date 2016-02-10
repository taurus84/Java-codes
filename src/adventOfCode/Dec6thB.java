package adventOfCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec6thB {

	public final int OFF = 0, ON = 1, TOGGLE = 2;
	public int startRow, endRow, startCol, endCol;
	
	
	public int litLightsValue() throws IOException {
		
		int[][] lights = new int[1000][1000];
		int lightsValue = 0;
		BufferedReader br = new BufferedReader(new FileReader("src/adventOfCode/dec6th.txt"));
		String str;
		while((str = br.readLine()) != null) {
			int whatToDoo = whatToDo(str);
			setStartEnd(whatToDoo, str);
			for(int i = startRow; i <= endRow; i++) {
				for(int j = startCol; j <= endCol; j++) {
					if(whatToDoo == ON) {
						lights[i][j]++;
					} else if(whatToDoo == OFF) {
						if(lights[i][j] != 0) {
							lights[i][j]--;
						}
					} else {
						lights[i][j] += 2;
					}
				}
			}
		}
		
		for(int[] elem : lights) {
			for(int sum : elem) {
				lightsValue += sum;
			}
		}
		return lightsValue;
	}
	
	public int whatToDo(String str) {
		String[] strArray = str.split(" ");
		if(strArray[0].startsWith("toggle")) {
			return TOGGLE;
		} else if(strArray[1].startsWith("on")) {
			return ON;
		}
		return OFF;
	}
	
	public void setStartEnd(int a, String str) {
		String[] arrayString = str.split(" ");
		if(a == TOGGLE) {
			startRow = Integer.parseInt(arrayString[1].split(",")[0]);
			startCol = Integer.parseInt(arrayString[1].split(",")[1]);
			endRow 	 = Integer.parseInt(arrayString[3].split(",")[0]);
			endCol 	 = Integer.parseInt(arrayString[3].split(",")[1]);
		} else {
			startRow = Integer.parseInt(arrayString[2].split(",")[0]);
			startCol = Integer.parseInt(arrayString[2].split(",")[1]);
			endRow 	 = Integer.parseInt(arrayString[4].split(",")[0]);
			endCol 	 = Integer.parseInt(arrayString[4].split(",")[1]);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Dec6thB dc = new Dec6thB();
		System.out.print(dc.litLightsValue());
	}
	
}
