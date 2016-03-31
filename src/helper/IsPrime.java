package helper;

public class IsPrime {

	public static boolean isPrime(long nbr) {

		for (int i = 2; i < nbr; i++) {
			if (nbr % i == 0) {
				return false;
			}
		}
		return true;
	}
}
