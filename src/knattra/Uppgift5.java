package knattra;

/**
 * Answer is 55374
 * @author David
 *
 */
public class Uppgift5 {
	public static void mergeSortDesc(double[] array) {
		double[] temp = new double[array.length];
		mergesortDesc(array, 0, array.length, temp);
		temp = null;
	}

	private static void mergesortDesc(double[] array, int first, int n,
			double[] temp) {
		int n1, n2;
		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;
			mergesortDesc(array, first, n1, temp);
			mergesortDesc(array, first + n1, n2, temp);
			// mergeDesc(array, first, n1, n2, temp);
		}
	}

	static int counter = 0;
//	public static void split(int nbr) {
//		split(nbr, 0, array.length);
	}

	public static void split(int nbr, int first, int n) {
		
		split(nbr-1)
		counter++;
		System.out.println(counter);
		int n1, n2;
		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;
			split(array, first, n1);
			split(array, first + n1, n2);
		}
	}

	public static void main(String[] args) {

		Uppgift5 prog = new Uppgift5();
		prog.split(new int[4]);
	}

}
