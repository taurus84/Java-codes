package adventOfCode2016;

import java.io.IOException;

public class Dec1 {

	public static void main(String[] args) throws IOException {
		
		//currentDir start north
		final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3, LEFT = 0, RIGHT = 1;
		int[][] table = {	
				{WEST, EAST},
				{NORTH, SOUTH},
				{EAST, WEST},
				{SOUTH, NORTH}};
		String str = "L4, L1, R4, R1, R1, L3, R5, L5, L2, L3, R2, R1, L4, R5, R4, L2, R1, R3, L5, R1, L3, L2, R5, L4, L5, R1, R2, L1, R5, L3, R2, R2, L1, R5, R2, L1, L1, R2, L1, R1, L2, L2, R4, R3, R2, L3, L188, L3, R2, R54, R1, R1, L2, L4, L3, L2, R3, L1, L1, R3, R5, L1, R5, L1, L1, R2, R4, R4, L5, L4, L1, R2, R4, R5, L2, L3, R5, L5, R1, R5, L2, R4, L2, L1, R4, R3, R4, L4, R3, L4, R78, R2, L3, R188, R2, R3, L2, R2, R3, R1, R5, R1, L1, L1, R4, R2, R1, R5, L1, R4, L4, R2, R5, L2, L5, R4, L3, L2, R1, R1, L5, L4, R1, L5, L1, L5, L1, L4, L3, L5, R4, R5, R2, L5, R5, R5, R4, R2, L1, L2, R3, R5, R5, R5, L2, L1, R4, R3, R1, L4, L2, L3, R2, L3, L5, L2, L2, L1, L2, R5, L2, L2, L3, L1, R1, L4, R2, L4, R3, R5, R3, R4, R1, R5, L3, L5, L5, L3, L2, L1, R3, L4, R3, R2, L1, R3, R1, L2, R4, L3, L3, L3, L1, L2";
		
		str = str.replaceAll("\\s", "");
		String[] splitString = str.split(",");
		int nextTurn, currentDir = NORTH, X = 0, Y = 0, steps;
		String direction = "";
		for(int i = 0; i < splitString.length; i++) {
			if(splitString[i].charAt(0) == 'L')	nextTurn = LEFT;
			else								nextTurn = RIGHT;
			steps = Integer.parseInt(splitString[i].charAt(1) + "");
			currentDir = table[currentDir][nextTurn];
			switch(currentDir) {
				case NORTH:
					Y += steps;
					direction = "NORTH";
					break;
				case EAST:
					X += steps;
					direction = "EAST";
					break;
				case SOUTH:
					Y -= steps;
					direction = "SOUTH";
					break;
				case WEST:
					X -= steps;
					direction = "WEST";
					
			}
			System.out.println("Went " + direction + " " + steps + "steps \nX: " + X + "\nY: " + Y);
		}
		
//		System.out.println(X);
//		System.out.println(Y);
	}
}
