package knattra;

public class Uppgift7 {
	
	public static void main(String[] args) {
		final int FIFTY = 50, TWENTY = 20, TEN = 10, FIVE = 5, ONE = 1;
		int sum = 100, ticker = 0;
		int[] fifty = new int[sum/FIFTY];
		int[] twenty = new int[sum/TWENTY];
		int[] ten = new int[sum/TEN];
		int[] five = new int[sum/FIVE];
		int[] one = new int[sum/ONE];
		
		for(int a = 0; a <= fifty.length; a++) {
			for(int b = 0; b <= twenty.length; b++) {
				for(int c = 0; c <= ten.length; c++) {
					for(int d = 0; d <= five.length; d++) {
						for(int e = 0; e <= one.length; e++) {
							int total = FIFTY*a + TWENTY*b + 
									TEN*c + FIVE*d + ONE*e;
							System.out.println(total);
							if(total == sum) {
								ticker++;
							}
						}
					}
				}
			}
		}
		
		
		
		System.out.println(ticker+1); //hundralappen ska med, hence +1
	}

}
