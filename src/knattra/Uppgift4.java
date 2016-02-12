package knattra;

public class Uppgift4 {

	public boolean up(int nbr) {
		String str = Integer.toString(nbr);
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) > str.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean down(int nbr) {
		String str = Integer.toString(nbr);
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) < str.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Uppgift4 prog = new Uppgift4();
		double percentage = 0;
		int number = 0, counter = 0;
		double hitNbr = (double)990/1000;
		System.out.println("Hit: " + hitNbr);
		while(!(hitNbr <= percentage)) {
			
			if(!prog.up(number) && !prog.down(number)) {
				counter++;
				
			}
			percentage = (double)counter/number;
			System.out.println("Counter: " + counter);
			System.out.println("Number: " + number);
			System.out.println(percentage);
			number++;
		}
		//Answer: 1587000
		
	}
}
