package knattra;

public class Uppgift2 {
	public static long reverse(long number) {

		long result = 0;

		while (number != 0) {
			long lastDigit = number % 10;
			result = result * 10 + lastDigit;
			number = number / 10;
		}

		return result;
	}

	public static boolean isPalindrome(long number) {
		return number == reverse(number);
	}
	
	public static void main(String[] args) {
		Uppgift2 prog = new Uppgift2();
		long nbr = 0, biggestNbr = 0;
		int jNbr = 0, iNbr = 0;
		for(int i = 100; i < 1000; i++) {
			for(int j = 100; j < 1000; j++) {
				nbr = i*j;
				if(prog.isPalindrome(nbr)) {
					if(nbr > biggestNbr) {
						biggestNbr = nbr;
					}
					
					jNbr = j;
					iNbr = i;
				}
			}
		}
		
		System.out.println(biggestNbr);
		System.out.println(jNbr);
		System.out.println(iNbr);
	}
}
