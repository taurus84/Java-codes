package knattra;

public class Uppgift10 {
	
	public static void main(String[] args) {
		final int UP = 0, RIGHT = 1, DOWN = 2, LEFT=3, CLOCKWISE = 0, ANTICLOCKWISE = 1;
		int x = 500, y = 500, visited = 1;
		int newDirection = 0;
		int[][] array = new int[1000][1000];
		int[][] direction = new int[][] {
				 { RIGHT, DOWN, LEFT, UP,},
				 { LEFT, UP, RIGHT, DOWN,},
		};
		
		String str = "<^^^^^^<^<<^^^<^<<^<<<<<<^<<^^<<^<<^<<<^^<<<<^<<<<<<<<^<^^<<<<<^^^<<^^<^<<<<^<<<^<<^^<<<<<^<<^^<<<<<<<<<^<<^<<<^<^<<<<^^^^^<<<<^<<<^<<^<^^<<^^<<^^^<<<^<<<<<<<^<<<<^<<<<<^<<<<<<^^<^<^<<<<<^^^^<^<<^<<<<^<<<<<<<^^<<<<^^<<<<<<<^<^<<<^<<<<<<<<^<<<<<<<^^^^<^<<<<<<<^<<<<^<<<<^^^^^<^<<<<<<<^<<<^^<<<<^^^<<<<^^<<^^^^^<<<<<^<^<<<<^<<^^<^<<<^<<^<<<<^<<^^<<<<<^^<<<<<<<^^<^<^^<<^^^<^<<<^<<<<<^<^<<<^<^<^^^<<<^<^<<^<<<^<^<<<<<^<<<^<<^<<<<<<<<<<<^^<^<<<^<^<^<<<<<<<<<<^<<<^<<^<^<<<<<<<<<<^^<<<^<<<^^<^<<<^<<<^<<<< ";
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '>') {
				newDirection = direction[CLOCKWISE][newDirection];
			} else if(c == '<') {
				newDirection = direction[ANTICLOCKWISE][newDirection];
			} else {
				switch(newDirection) {
				case UP:
					y++;
					break;
				case RIGHT:
					
					break;
				case DOWN:
					break;
				case LEFT:
					break;
				}
			}
		}
		
	}
	
}
