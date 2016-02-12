package collections;
import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

/**
 * Klassen som lägger element på stacken
 * och ta bort element från stacken.
 * @author Zeid Bekli
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] elements;
    private int size=0;
    
    /**
     * Konstruktorn skapar en stack med en viss kapacitet.
     * @param capacity stackens kapacitet.
     */
    public ArrayStack(int capacity) {
        elements = (T[])(new Object[capacity]);
    }

    /**
     * Metod som lägger ett elemet på stacken
     */
    public void push(T element) {
    	if(size>=elements.length)
    		throw new BufferOverflowException();
        elements[ size ] = element;
        size++;
    }

    /**
     * Metod som tar ett element från stacken.
     */
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * kollar på ett element i stacken
     */
    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }

    /**
     * Metod som kontrollerar om stacken är tom
     */
    public boolean isEmpty() {
        return (size==0);
    }

    /**
     * stackens storlek
     */
    public int size() {
        return size;
    }

    /**
     * Main metod.
     * @param args
     */
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(20);
        Integer elem;
        for(int i=0; i<10; i++) {
            stack.push(new Integer(i));
        }
        while(!stack.isEmpty()) {
            elem = stack.pop();
            System.out.print(elem + " ");
        }
    }
}
