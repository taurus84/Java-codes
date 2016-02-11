package knattra;

public class Uppgift4 {

	public boolean up(long nbr) {
		String str = Long.toString(nbr);
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) > str.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean down(long nbr) {
		String str = Long.toString(nbr);
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) < str.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Uppgift4 prog = new Uppgift4();
//		System.out.print(prog.down(1000));
//		System.out.println(sum);
		long percentage = 0;
		long number = 1;
		long counter = 1;
		while(percentage <= 50) {
			
			if(!prog.up(number) && !prog.down(number)) {
				counter++;
				System.out.println(counter);
				percentage = (counter/number);
			}
			number++;
		}
		
		System.out.println(counter);
		
	}
}
