package adventOfCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec6th {

	public final int OFF = 0, ON = 1, TOGGLE = 2;
	public int startRow, endRow, startCol, endCol;
	
	
	public int litLights() throws IOException {
		
		boolean[][] lights = new boolean[1000][1000];
		int nbrOfLitLights = 0;
		BufferedReader br = new BufferedReader(new FileReader("src/adventOfCode/dec6th.txt"));
		String str;
		while((str = br.readLine()) != null) {
			int whatToDoo = whatToDo(str);
			setStartEnd(whatToDoo, str);
			for(int i = startRow; i <= endRow; i++) {
				for(int j = startCol; j <= endCol; j++) {
					if(whatToDoo == ON) {
						lights[i][j] = true;			//turn on lights
					} else if(whatToDoo == OFF) {
						lights[i][j] = false;			//turn off lights
					} else {
						lights[i][j] = !lights[i][j];	//toggle lights
					}
				}
			}
		}
		
		/* count the lit lights */
		for(boolean[] elem : lights) {
			for(boolean bool : elem) {
				if(bool) {
					nbrOfLitLights++;
				}
			}
		}
		return nbrOfLitLights;
	}
	
	/**
	 * String looks different if toggle. So we have to see if it's a toggle or not
	 */
	public int whatToDo(String str) {
		String[] strArray = str.split(" ");
		if(strArray[0].startsWith("toggle")) {
			return TOGGLE;
		} else if(strArray[1].startsWith("on")) {
			return ON;
		}
		return OFF;
	}
	
	/**
	 * String with toggle have different stringBuilding, which means different
	 * index for the string which contains start and end points
	 */
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
		Dec6th dc = new Dec6th();
		System.out.print(dc.litLights());
	}
	
}
