package knattra;

public class Uppgift3 {
	
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 3; i < 1000; i++) {
			if(i%3 == 0 && i%7 == 0) {
				sum += i;
			} else if (i%3 == 0) {
				sum += i;
			} else if(i%7 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
	}
}
