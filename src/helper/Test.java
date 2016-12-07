package helper;

public class Test {
	
	public static void max(int a, int b) {
		a = a+1;
		System.out.println("MAX a: " + a);
	}
	
	public static void min(int a, int b) {
		b = b+1;
		System.out.println("MIN b: " + b);
	}
	
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		max(a,b);
		min(a,b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		
		
		
	}

}
