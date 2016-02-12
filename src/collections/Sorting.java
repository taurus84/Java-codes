package collections;


/**
 * 	Sorting är en sorterings klass som sorterar en array
 * 	med sorterings metoder quicksort och mergsort .
 * 
 * 
 * 	@author Zeid Bekli
 *
 */

public class Sorting {
		public static void sort(double[] array){
		int right = array.length-1;
		quicksort(array,0,right);
	}
	
	/**
	 * 	quicksort() funkar endast om arrayen har två
	 * 	eller mer element. 
	 * 	Den tar ett element och gemför med den när den sorterar
	 * 	sedan kollar den nästa element.
	 * 	allt som är större än elementet går till höger och allt
	 * 	som är mindre går till vänster
	 * 
	 *	@param array
	 * 	@param left
	 * 	@param right
	 */
	
	public static void quicksort(double[] array,int left,int right){
		int pivotIndex;
		if( left < right ) { // minst två element
			pivotIndex = partition(array, left, right, (left+right)/2); // flytta elementen 
			quicksort( array, left, pivotIndex-1); 
			quicksort( array, pivotIndex+1, right); 
		}
	}
	

	private static int partition(double[] arr, int left, int right, int pivotIndex) {
		double pivotValue = arr[pivotIndex];
		int storeIndex = left;
		swap(arr,pivotIndex,right);
		for(int i=left; i<right; i++) {
			if(arr[i]<pivotValue) {
				swap(arr,i,storeIndex);
				storeIndex++;
			}
		}
		swap(arr,storeIndex,right);
		return storeIndex;
	}
	

	private static void swap(double[] arr, int left, int right) {
		double temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	} 
	
	/**
	 * sorterar en ArrayList med mergesort.
	 * det är att den delar upp arrayen i små listor
	 *  som sedan adderas ihop(divide and conquer)
	 * 
	 * @param list
	 */
	public static <E> void sort(ArrayList<E> list){
		mergesort( list, 0, list.size());
	}

	private static <E> void mergesort(ArrayList<E> list, int first, int n ) {
		int n1,n2;
		if( n > 1 ) {
			n1 = n / 2; 
			n2 = n - n1;
			mergesort( list, first, n1 );
			mergesort( list, first + n1, n2);
			merge( list, first, n1, n2 );
		}
	}

	private static <E> void merge( ArrayList<E> list, int first, int n1, int n2 ) {
		int counter = 0, cursor1 = 0, cursor2 = n1, end = n1 + n2,res=0;
		E[] temp = (E[])new Object[list.size()];

		while ((cursor1 < n1) && (cursor2 < end)) {
			if((list.get(first + cursor1)!=null)&&(list.get(first + cursor2)!=null)){
				res = ((Comparable<E>) list.get(first + cursor1)).compareTo(list.get(first + cursor2));
			}
			if ( res < 0) {
				temp[counter] = list.get(first+cursor1);
				cursor1++;
			} else {
				temp[counter] = list.get(first+cursor2);
				cursor2++;
			}
			counter++;
		}
		while (cursor1 < n1) {
			E d = list.get(first + cursor1);
			temp[counter] = d;
			cursor1++;
			counter++;
		}
		while (cursor2 < end) {
			E d = list.get(first + cursor2);
			temp[counter] = d;
			cursor2++;
			counter++;
		}
		for (int i = 0; i < n1 + n2; i++) {
			list.set(first + i, temp[i]);
		}
	}
}
