package helper;

public class Multiples3and5 {
	
	public static void main(String[] args) {
		int nbr = 1000;
		int sum = 0;
		for(int i = 0; i < nbr; i++) {
			if(i%3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		System.out.print(sum);
	}
	

}
