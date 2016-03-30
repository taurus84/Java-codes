package helper;

public class SumSquareDifference {
	
	public static void main(String[] args) {
	
		long sumOfSquares = 0;
		long squareOfSums = 0;
		
		for(int i = 1; i <= 100; i++) {
			sumOfSquares += i*i;
			squareOfSums += i;
			
		}
		squareOfSums *= squareOfSums;
		
		System.out.print(squareOfSums-sumOfSquares);
	}

}
