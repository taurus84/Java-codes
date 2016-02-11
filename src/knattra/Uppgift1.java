package knattra;

public class Uppgift1 {

	public long fib(int n) {
		return fib(n, 1, 1);
	}

	private long fib(int n, int n1, int n2) {
		if (n <= 2)
			return n2;
		else
			return fib(n - 1, n2, n1 + n2);
	}
	
	public static void main(String[] args) {
		Uppgift1 prog = new Uppgift1();
		long sum = 0, fibNr = 0;
		int counter1 = 10, counter2;
		while(fibNr < 3000000) {
			fibNr = prog.fib(counter1);
			counter1++;
		}
		for(int i = 0; i <=34; i++) {
			fibNr = prog.fib(i);
			if(fibNr %2 == 0) {
				sum += fibNr;
			}
		}
		System.out.print(sum);
		
	}
	
	
}
