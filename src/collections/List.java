package collections;
import java.util.Iterator;

public interface List<E> {
	
	/**
     * Lägger till den angivna elementet till slutet av denna lista 
     * @param element elementet som skall bifogas till listan
     */	
	public void add(E element);

    /**
     * Infogar den angivna elementet vid den angivna positionen i den här listan.
     * Skiftar elementet i den närvarande positionen om det finns någon och den som
     * är till höger läggs in i index.
     * @param index index vid vilket den angivna elementet skall införas
     * @param element element som ska läggas till
     */
	public void add(int index, E element);
	
	/**
     * Infogar den angivna elementet i början av denna lista 
     * @param element 
     */	
	public void addFirst(E element);
	
	/**
     * lägger till den specifika element i slutet av listan 
     * @param element
     */	
	public void addLast(E element);

    /**
     * Tar bort elementet vid den angivna positionen i den här listan.
     * Skiftar eventuella element till vänster (subtraherar ett från sina index).
     * Returnerar elementet som togs bort från listan.
     * @param index indexet för det element som ska tas bort.
     * @return  elementet vid  tidigare position
     */
	public E remove(int index);

    /**
     * Tar bort och retunerar första elementet
     * Removes and returns the first element from this list.
     * @return första elementet från listan
     */
	public E removeFirst();
	
    /**
     * Tar bort och retunerar sista elementet
     * @return sista elementet
     */
	public E removeLast();

    /**
     * tar bort alla element från listan 
     */
	public void clear();
	
    /**
     * returneran element från den specifika positionen 
     * @param index index av elementet retuneras 
     */
	public E get(int index);
	
    /**
     * Ersätter elementet vid den angivna positionen i listan med det angivna elementet
     * @param index index av elementet ersätts
     * @param element element ska sparas vid den angiva positionen. 
     */
	public E set(int index, E element);
	
    /**
     * Returnerar indexvärdet för den första angiva elementet i listan
     * och -1 om det inte innehåller elementet.
     * @param element söker angiven element 
     */
	public int indexOf(E element);
	
    /**
     * Returnerar indexvärdet för den första angiva elementet i listan
     * och -1 om det inte innehåller elementet.
     * Sökningen startar vid startindex i listan.
     * @param startIndex sökningen börjar i starindex i listan
     * @param element söker angiven element 
     */
	public int indexOf(int startIndex, E element);
	
    /**
     * Returnerar ett iterator över elementen i denna lista i rätt ordning.
     */
	public Iterator<E> iterator();
	
    /**
     * retunerar antal elements i listan
     */
	public int size();
}
