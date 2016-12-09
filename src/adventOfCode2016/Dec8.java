package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec8 {
	
	private final int OFF = 0;
	private static final int ON = 1;
	static int[][] matris = new int[6][50];
	
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec8.txt"));
		String s;
		while((s = r.readLine()) != null) {
			String[] splitString = s.split("\\s+");
			if(splitString[0].equals("rect")) {
				String[] values = splitString[1].split("x");
				int width = Integer.parseInt(values[0]);
				int height = Integer.parseInt(values[1]);
				turnOn(width, height);
			} else if(splitString[1].equals("row")) {
				int row = Integer.parseInt(splitString[2].split("=")[1]);
				int nbrOfShifts = Integer.parseInt(splitString[4]);
				for(int i = 0; i < nbrOfShifts; i++) {
					rotateRow(row);
				}
			} else if(splitString[1].equals("column")) {
				int col = Integer.parseInt(splitString[2].split("=")[1]);
				int nbrOfShifts = Integer.parseInt(splitString[4]);
				for(int i = 0; i < nbrOfShifts; i++) {
					rotateCol(col);
				}
			}
		}
		System.out.println(getLitPixels());
		print();
	}
	
	
	public static void turnOn(int width, int height) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				matris[i][j] = ON;
			}
		}
	}
	
	public static void rotateRow(int row) {
		int carry = matris[row][matris[row].length-1];
		for(int i = matris[row].length -2; i >= 0; i--) {
			matris[row][i+1] = matris[row][i];
		}
		matris[row][0] = carry;
	}
	
	public static void rotateCol(int col) {
		int carry = matris[5][col];
		for(int i = matris.length -2; i >= 0; i--) {
			matris[i+1][col] = matris[i][col];
		}
		matris[0][col] = carry;
	}
	
	public static int getLitPixels() {
		int counter = 0;
		for(int[] row : matris) {
			for(int elem : row) {
				if(elem == ON) counter++;
			}
		}
		return counter;
	}
	
	public static void print() {
		for(int row = 0; row < 6; row++) {
			for(int col = 0; col < 50; col++) {
				if(col%5 == 0) System.out.print(" ");
				System.out.print(matris[row][col]);
				
			}
			System.out.println();
		}
	}
	
	// ZFHFSFOGPO
	
	
}
