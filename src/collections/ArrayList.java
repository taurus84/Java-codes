package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Array som implementerar list.
 * användaren har kontroll över var dom olika elementen ska vara i listan.
 * 
 * 
 * 
 * @author Zeid bekli
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;

	/** 
	 * 	metoden grow() gör så att arrayen blir större. 
	 * 	Genom att göra den dubbelt så stor som förra arrayen.
	 * 
	 * @param ändra storleken på array
	 * */ 
	private void grow() {
		E[] temp = (E[]) new Object[elements.length*2]; 
		for(int i = 0; i < elements.length; i++){ 
			temp[i] = elements[i] ; 
		} 
		elements = temp; 
	}
	
	/**
	 * 	Konstruktor #1 som anger storlek på array.
	 * 
	 */
	
	public ArrayList() {
		this(20);
	}
	
	/**
	 * 	Konstruktor #2 som initirar kapitalet av objekt. 
	 * 
	 * @param initialCapacity
	 */
	
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}
	
	/**
	 * 	Metoden add(int index, E element) är för att lägga element på 
	 * specefika ställen i arrayen. 
	 * 
	 */
	
	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 	add(E element) lägger till element i arrayen.
	 * 
	 */
	
	public void add(E element) {
		add(size,element);
	}
	
	/**
	 *	addFirst() lägger till element först i arrayen. 
	 * 
	 */
	
	public void addFirst(E element) {
		add(0, element);
	}
	
	/**
	 *	addLast() lägger till element sist i arrayen. 
	 * 
	 */
	
	public void addLast(E element) {
		add(size, element);
	}
	
	/**
	 * 	remove() är en metod som tar bort
	 * 	ett specifikt element ifrån arrayen.
	 * 
	 */
	
	public E remove(int index) {
		if(index > size && index <0 ) {
			throw new IndexOutOfBoundsException();
		}

		E element = elements[index];

		size--;
		for (int i=index; i<size; i++) {
			elements[i] = elements[i+1];
		}
		return element;
	}

	/**
	 * 	removeFirst() tar bort första elementet i 
	 * 	arrayen och retunerar det.
	 * 
	 * 	@return 0 första elementet
	 */
	
	public E removeFirst() {
		return remove(0);
	}


	/**
	 * 	removeLast() tar bort sista elementet i 
	 * 	arrayen och retunerar det. 
	 * 	
	 * 	@return size -1, tar bort sista elementet
	 */
	public E removeLast() {
		return remove(size-1);
	}
	
	/**
	 * clear() nollställer arrayen 
	 * 
	 */
	
	public void clear() {
		for(int i=size; i>0; i--) {
			elements[i] = null;
		}
		size=0;
	}



	/**
	 * 	get( ) Retunerar objektet ur listan från en specifik position	 * 
	 * 	@return
	 */
	public E get(int index) {
		if(index > size && index <0) 
			throw new IndexOutOfBoundsException();
		return this.elements[index];
	}


	/**
	 * 	set() byter ut ett specifikt element i listan med ett specifikt element,
	 * 	retunerar sedan det utbytna elementet.
	 * 		
	 * 	@return
	 */
	public E set(int index, E element) {
		if(index > size && index <0) 
			throw new IndexOutOfBoundsException();
		E prevElement = elements[index];

		elements[index] = element;
		return prevElement;
	}


	/**
	 * 	indexOf() retunerar positionen i listan av det angivna elementet,
	 * 	eller -1 om elementet inte finns.
	 * 
	 * 	@return
	 */
	public int indexOf(E element) {
		for(int i =0; i < size; i ++) {
			if(elements[i].equals(element))
				return i;
		}
		return -1;
	}


	/**
	 * 	indexOf() retunerar positionen i listan av det angivna elementet,
	 * 	eller -1 om elementet inte finns. Sökningen startar på en specifik plats.
	 * 
	 * 	@return
	 */
	public int indexOf(int startIndex, E element) {
		if (startIndex > size && startIndex < 0) 
			throw new IndexOutOfBoundsException();

		int i = startIndex;
		while (i<size) {
			if( elements[i].equals(element))
				return i;
			else 
				i++;
		}
		return -1;
	}



	/**
	 * 	size() retunerar antalet nummer av element i denna kollektion.
	 * 	
	 * 	@return
	 */
	public int size() {
		return this.size;
	}



	/**
	 * 	toString() skriver ut alla objekt i listan
	 * 
	 * 	@return
	 */
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}	


	/**
	 * 	iterator() itererar igenom listan och retunerar objekten.
	 * 	
	 * 	@return
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}	
	
	private class Iter implements Iterator<E> {
		private int index=0;		    	


		public boolean hasNext() {
			return index<size;
		}

		public E next() {
			if (index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}



	public static void main(String[] args) {
		//		ArrayList<Integer> list = new ArrayList<Integer>(10);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		//		double[] sortArray = {24.6, 12.3, 87.3, 2.2, 456.7, 11,74,5,7,5,4,1,1,1,87,875,2,89,4,78,24,78,25,788,1};
		//		int [] sortMerge = {5,4,1,1,1,87,875,2,89,4,78,24,78,25,788,1};
		for(int i=10; i<100; i+=10) {
			list2.add(i);
		}
		System.out.println(list2);
		list2.clear();

		for(int i=10; i<100; i+=10) {
			list2.add(i);
		}
		System.out.println(list2);
		//		
		//
		//
		//		
		Iterator<Integer> numbers = list2.iterator();
		while(numbers.hasNext())
			System.out.print(numbers.next()+ " ");
		System.out.println();
	}

}
//		
//		System.out.println(Searching.linearSearch(list, 90));
//		System.out.println(Searching.binearSearch(list, 10));
//		
//		Test QuickSort
//		Sorting.sort(sortArray);
//		for(int i=0; i<sortArray.length; i++) {
//			System.out.print(sortArray[i]+ " ");
//		}
//		
//		Test MergeSort		
//		Sorting.mergesort(list);
//		for(int i=0; i<list.size; i++) {
//			System.out.print(list+ " ");
//		}
//	}
//		
//	}
