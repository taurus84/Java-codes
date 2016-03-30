package helper;

public class Prime {

	public static void main(String[] args) {

		long number = 600851475143L;
		for (long i = 1; i < number; i++) {
			if (number % i == 0) {
				if (prime(number / i)) {
					System.out.println(number / i);
					break;
				}
			}
		}
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
