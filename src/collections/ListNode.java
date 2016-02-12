package collections;

/**
 * ListNode 
 * 
 * 
 * @author Zeid Bekli
 *
 * @param <E>
 */

public class ListNode<E> {
    private E data;
    private ListNode<E> next;
    /**
     * Konstruktorn ListNode har två variabler
     * 
     * 
     * @param data
     * @param next
     */
    public ListNode( E data, ListNode<E> next ) {
        this.data = data;
        this.next = next;
    }
    /**
     * getData hämtar ifrån valfrit område
     * 
     * @return
     */
    public E getData() {
        return this.data;
    }
    /**
     * setData anger ny data för listan
     * 
     * @param data
     */
    public void setData( E data ) {
        this.data = data;
    }
    /**
     * 
     * @return
     */
    public ListNode<E> getNext() {
        return this.next;
    }
    /**
     * 
     * @param next
     */
    public void setNext( ListNode<E> next ) {
        this.next = next;
    }
    /**
     * 
     */
    public String toString() {
    	StringBuilder str = new StringBuilder("[ ");
    	str.append(data.toString());
    	ListNode<E> node = next;
        while( node!=null ) {
        	str.append( "; ");
            str.append( node.getData().toString() );
            node = node.getNext();
        }
        str.append( " ]");
        return str.toString();
    }
}