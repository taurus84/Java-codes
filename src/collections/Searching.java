package collections;

/**
 * 	Searching är en klass som innehåller binär sökning
 *  och linjär sökning.
 * 	Det är 2 olika sätt att söka genom en array
 *  med en specifikt element som man söker efter.
 * 
 * 	@author Zeid Bekli
 *
 */

public class Searching {

	/**
	 * 	binär sökning är inte den snabbaste metoden att söka med
	 * 	men den fungar bra när den söker mindre listor 
	 * 	där den kollar förs i mitten och kollar om värdet
	 *  är den man söker efter eller inte.
	 * 	Och om det inte är så kollar om den är större så går den backåt
	 *  och om den är mindre går den frammåt.
	 *  
	 *  sökningsmetoden är för sorterad lista
	 * 
	 * 	@param list
	 * 	@param element
	 * 	@return
	 */
	
	public static <E> int binearSearch(ArrayList<E> list, E element){
		int result = -1, compare, min = 0, max = list.size() - 1, pos;
		Comparable<E> comp = (Comparable<E>)element;
		while( ( min <= max ) && ( result == -1 ) ) {
			pos = (min + max) / 2;
			compare = comp.compareTo( list.get(pos));
			if( compare == 0 )
				result = pos;
			else if( compare < 0 )
				max = pos - 1;			
			else
				min = pos + 1;
		}
		return result;
	}
	
	/**
	 * 	linjär sökning är en sökmetod  som söker genom arrayen
	 *  från pos0 tills den hittar den angivna elementet
	 * 
	 * 	sökmetoden är för en osorterad lista
	 * 
	 * 	@param list
	 * 	@param element
	 * 	@return
	 */
	
	public static <E> int linearSearch(List<E> list, E element){
		
		int result = -1; 
		boolean compare;
		Comparable<E> comp = (Comparable<E>)element;
		for(int i = 0;i<list.size();i++){
			compare = comp.equals(( list.get(i)));
			if(compare == true)
				result = i;
		}
		return result;

	}

}
