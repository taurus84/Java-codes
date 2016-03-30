package helper;

public class WhatIsThePrime {

	public static void main(String[] args) {
		int nbrOfPrimes = 0;
		long nbr = 1;
		while(nbrOfPrimes != 10001) {
			nbr++;
			if(prime(nbr)) {
				nbrOfPrimes++;
				System.out.println(nbr);
			}
				
			
		}
		System.out.println("Finished:  " + nbr);
	}
	static boolean prime(long number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
