package helper;

public class SummationOfPrimes {

	public static void main(String[] args) {
		long sum = 0;
		for(long i = 2; i < 2000000; i++) {
			if(IsPrime.isPrime(i)) {
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println("Finished!" + sum);
	}
}
