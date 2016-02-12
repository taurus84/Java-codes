package knattra;

public class Uppgift8 {
	
	public static void main(String[] args) {
		
		double mostSteps = 0, nbrWithMostSteps = 1;
		
		for(double i = 100000; i < 1000000; i++) {
			double nbr = i, steps = 0;
			System.out.println(i);
			while(nbr != 1) {
				if(nbr%2 == 0) {
					nbr = nbr/2;
				} else {
					nbr = nbr*3 + 1; 
				}
				steps++;
			}
			if(steps > mostSteps) {
				mostSteps = steps;
				nbrWithMostSteps = i;
//				System.out.println(nbrWithMostSteps);
//				System.out.println(i);
			}
		}
		
		System.out.println(nbrWithMostSteps);
	}

}
