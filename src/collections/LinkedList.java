package collections;

import java.util.Iterator;


/** 
 * 	länkad lista används för att visa och 
 * 	ordna en flexibelt lista med object.
 * 
 * 
 * 	@author Zeid Bekli
 *
 * 	@param <E>
 */

public class LinkedList<E> implements List<E>, Iterable<E> {
    private ListNode<E> list = null;

    private ListNode<E> locate(int index) {
        ListNode<E> node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }
    
    
    /**
     * 	size() returnerar hur många element som finns i listan.
     * 	
     * 	@return
     */
    public int size() {
        int n = 0;
        ListNode<E> node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }
    
    
    /**
     * 	get() retunerar objektet i en specifik position ur listan.
     * 
     * 	@return
     */
    public E get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ListNode<E> node = locate( index );
        return node.getData();
    }
    
    
    /**
     * 	set() byter ut ett element ur listan med en element.
     *  Retunerar de utbyta elementet.
     *
     */
    public E set( int index, E data ) { 
    	if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );    	
    	
    	E res = remove(index);
    	add(index, data);
    	
    	return res;
    }
    
    
    /**
     * 	add() sätter in ett element sist i listan.
     *
     */
	public void add(E data) {
		add(size(), data);
	}
	
	
	/**
	 * 	addFirst()sätter in ett element först i listan.
	 *
	 */
    public void addFirst( E data ) {
    	add(0, data);
    }
    
    
    /**
     * 	addLast() sätter in ett element sist i listan.
     *
     */
    public void addLast( E data ) {
    	add(size(), data);
    }
    
    
    /**
     * 	add() sätter in ett nytt specifikt element i en angiven position i listan,
     * 	flyttar sedan resterande element ett steg till höger.
     *
     */
    public void add( int index, E data ) {
    	if( ( index < 0 ) || (index > size() ))
    		throw new IndexOutOfBoundsException("size=" + size() );
    	
    		if( index == 0 )
    			list = new ListNode<E> (data, list);
    		
    		else {
    			ListNode<E> node = locate ( index -1);
    			ListNode<E> newNode = new ListNode<E>(data, node.getNext() );
    			node.setNext(newNode);
    		}    		
    }
    
    
    /**
     * 	removeFirst() tar bort och retunerar 
     *  första elementet i listan
     * 	
     * 	@return
     */
    public E removeFirst() {    	
    	return remove (0);
    }
    
    
    /**
     * 	removeLast() tar bort sista elementet och returnerar den.
     * 
     * 	@return
     */
    public E removeLast() {
    	return remove(size()-1);
    }
    
    
    /**
     * 	remove() tar bort ett element ur en specifik position i listan,
     * 	flyttar sedan resterande element ett steg till vänster.
     *	
     *	@return
     */
    public E remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        E res;
        if( index == 0 ) {
            res = list.getData();
            list = list.getNext();
        } else {
            ListNode<E> node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    
    /**
     * 	clear() rensar hela listan.
     *
     */
    
	public void clear() {
		for (int i = size()-1; i>0; i--) {
			locate(i).setData(null);			//ListNode<E> node = locate(i);
	//		locate(i).setData(null);
		}
		list = null;
	}
	
	
	/**
	 * 	indexOf() retunerar indexet på det angivna elementet, 
	 * 	om angivet element inte existerar retuneras -1.
	 * 
	 * 	@return
	 */
	
	public int indexOf(E data) {
		return indexOf(0, data);
	}
	
	
	/**
	 * 	indexOf()retunerar indexet på det angivna elementet, 
	 * 	om angivet element inte existerar retuneras -1.
	 * 	Sökningen startar i (startIndex).
	 * 
	 * 	@return
	 */
	
	public int indexOf(int startIndex, E data) {
		if (startIndex > size() && startIndex < 0 )
			throw new IndexOutOfBoundsException();
		
		int i = startIndex;
		while (i < size()) {
			if(locate(i).getData().equals(data))
				return i;
			else 
			i++;	
		}
		return -1;
	}
	
	/**
	 * 	interator()itererar och retunerar listan.
	 * 
	 * 	@return
	 */

	public Iterator<E> iterator() {
		return new Iter();
	}    
    
	
	/**
	 * 	toString() skriver ut lista om det inte är tom.
	 * 
	 * 	@return
	 */
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    private class Iter implements Iterator<E> {
    	int index = 0;
    	
    	public boolean hasNext() {
    		return index < size();
    	}
    	
    	/**
    	 * Retunerar nästa element i listan.
    	 */
    	public E next() {
    		return get(index++);
    	}
    	
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
}
