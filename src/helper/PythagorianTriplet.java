package helper;

public class PythagorianTriplet {

	public static void main(String[] args) {
		int a, b, c;
		
		for(int i = 2; i < 1000; i++) {
			b = i;
			for(int j = 1; j < b; j++) {
				a = j;
				c = 1000-b-a;
				int difference = c*c - b*b - a*a;
				if(difference == 0) {
					System.out.println("Found it!: " + a + "+" + b + "+" + c + "=" + a*b*c);
				}
			}
		}
			
	}
}
