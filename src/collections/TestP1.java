package collections;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import collections.*;

public class TestP1 {
    
	private static boolean test(boolean condition, String... message ) {
        if (condition && message.length>0)
            System.out.println("  "+message[0]);
        else if (message.length > 1)
            System.out.println("  "+message[1]);
        return condition;
    }
    
    private static <E> String strList(List<E> arr) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i=0; i<arr.size(); i++) {
            str.append(arr.get(i).toString());
            if(i<arr.size()-1)
                str.append(", ");
        }
        str.append("]");
        return str.toString();
    }

    private static boolean equals(List<Long> list, long[] arr) {
        if(list.size()!=arr.length)
            return false;
        boolean res = true;
        for(int i=0; i<arr.length && res; i++)
            res = arr[i]==list.get(i);
        return res;
    }
    
    private static int indexOf(long[] arr, long value) {
        for(int i=0; i<arr.length; i++)
            if(arr[i]==value)
                return i;
        return -1;
    }
    
    private static boolean sameMembers(List<Long> list, long[] arr) {
        boolean res = true;
        int pos;
        for(int i=0; list.size()==arr.length && i<arr.length && res; i++) {
            res = (pos = indexOf(arr,list.get(i))) >= 0;
            if(res)
                arr[pos]=-1;
        }
        return res;
    }
    
    private static void setList(List<Long> list, long min, long max) {
        while(min<=max)
            list.add(min++);
    }
    
    private static void shuffle(List<Long> list) {
        Random rand = new Random();
        int pos;
        Long temp;
        for(int i=list.size()-1; i>0; i--) {
            pos = rand.nextInt(i+1);
            temp = list.get(pos);
            list.set(pos,list.get(i));
            list.set(i,temp);
        }
    }
    
    // --------  Testmetoder fÃ¶r List  ---------------------------------------
    private static boolean testSize(List<Long> list, int size) {
    	return test(list.size()==size,"size(): OK","size()=="+size+": failed, size()=="+list.size());
    }
    
    private static boolean testSizeAddGet(List<Long> list) {
        System.out.println("------add(E), get(index)------------------");
    	boolean result = testSize(list,0);
        for(int i=0; i<3; i++) {
            list.add(new Long(i+2));     
        	result = result && testSize(list,i+1);
        	result = result && test(list.get(i)==(i+2),"list.get("+i+"): OK","list.get("+i+"): failed");
        }
        return result;
    }
    
    private static boolean testAddPos1(List<Long> list) {
        System.out.println("------add(size(),E) {2,3,4}------------------");
    	boolean result = true;
        for(int i=0; i<3; i++)
            list.add(i,new Long(i+2));     
        if(testSize(list,3)) {
        	test(equals(list,new long[]{2,3,4}), "add(index,element) OK", "add(element) {2,3,4} != " + strList(list));
        }
        return result;
    }
    
    private static boolean testAddPos2(List<Long> list) {
        System.out.println("------add(0,E) {2,3,4,5}------------------");
    	boolean result = true;
        for(int i=0; i<4; i++)
            list.add(0,new Long(i+2));     
        if(testSize(list,4)) {
        	test(equals(list,new long[]{5,4,3,2}), "add(0,element) OK", "add(0,element) {5,4,3,2} != " + strList(list));
        }
        return result;
    }
    
    private static boolean testAddFirst(List<Long> list) {
        System.out.println("------addFirst(E) {2,3,4}------------------");
    	boolean result = true;
        for(int i=0; i<3; i++)
            list.addFirst(new Long(i+2));     
        if(testSize(list,3)) {
        	test(equals(list,new long[]{4,3,2}), "addFirst(element) OK", "addFirst(element) {4,3,2} != " + strList(list));
        }
        return result;
    }
    
    private static boolean testAddLast(List<Long> list) {
        System.out.println("------addLast(E) {2,3,4,5}------------------");
    	boolean result = true;
        for(int i=0; i<4; i++)
            list.addLast(new Long(i+2));     
        if(testSize(list,4)) {
        	test(equals(list,new long[]{2,3,4,5}), "addLast(element) OK", "addLast(element) {2,3,4,5} != " + strList(list));
        }
        return result;
    }
    
    // KrÃ¤ver lista med size element
    private static boolean testClear(List<Long> list) {
        System.out.println("------clear()------------------");
        setList(list,10,15);
    	boolean result = testSize(list,6);
    	list.clear();
    	result = result && testSize(list,0);
    	return result;
    }
    
    private static boolean testSet(List<Long> list) {
        System.out.println("------set(index,E)------------------");
        setList(list,10,14);
        list.set(0,new Long(60));
        list.set(1,new Long(50));
        list.set(4,new Long(40));
    	boolean result = testSize(list,5);
    	result = result && test(equals(list,new long[]{60,50,12,13,40}), "set(index,E): OK", "set(index,E): {60,50,12,13,40} != " + strList(list));
    	return result;
    }
    
    public static boolean testRemovePos(List<Long> list) {
        System.out.println("------remove(index)------------------");
        boolean result = true;
        setList(list,16,19);
        result = result && test(list.remove(1)==17,"remove(1)==17: OK","remove(1)==17: failed");
        result = result && test(equals(list,new long[]{16,18,19}), "remove(1): OK", "remove(1): {16,18,19} != " + strList(list));
        result = result && test(list.remove(0)==16,"remove(0)==16: OK","remove(0)==16: failed");
        result = result && test(equals(list,new long[]{18,19}), "remove(0): OK", "remove(0): {18,19} != " + strList(list));
        result = result && testSize(list,2);
        return result;
    }
    
    public static boolean testRemoveFirst(List<Long> list) {
        System.out.println("------removeFirst()------------------");
        boolean result = true;
        setList(list,16,19);
        result = result && test(list.removeFirst()==16,"removeFirst()==16: OK","removeFirst()==16: failed");
        result = result && test(equals(list,new long[]{17,18,19}), "removeFirst(): OK", "removeFirst(): {17,18,19} != " + strList(list));
        result = result && test(list.removeFirst()==17,"removeFirst()==17: OK","removeFirst()==17: failed");
        result = result && test(equals(list,new long[]{18,19}), "removeFirst(): OK", "removeFirst(): {18,19} != " + strList(list));
        result = result && testSize(list,2);
        return result;
    }
    
    public static boolean testRemoveLast(List<Long> list) {
        System.out.println("------removeLast()------------------");
        boolean result = true;
        setList(list,16,19);
        result = result && test(list.removeLast()==19,"removeLast()==19: OK","removeLast()==19: failed");
        result = result && test(equals(list,new long[]{16,17,18}), "removeLast(): OK", "removeLast(): {16,17,18} != " + strList(list));
        result = result && test(list.removeLast()==18,"removeLast()==18: OK","removeLast()==18: failed");
        result = result && test(equals(list,new long[]{16,17}), "removeLast(): OK", "removeLast(): {16,17} != " + strList(list));
        result = result && testSize(list,2);
        return result;
    }
    
    private static boolean testIndexOf(List<Long> list) {
        System.out.println("------indexOf(E)------------------");
        boolean result = true;
        setList(list,16,19);
        result = result && test(list.indexOf(new Long(17))==1,"indexOf(E): OK","indexOf(E): failed");
        result = result && test(list.indexOf(new Long(20))==-1,"indexOf(E): OK","indexOf(E): failed");
        return result;
    }
    
    private static boolean testIndexOfPos(List<Long> list) {
        System.out.println("------indexOf(index,E)------------------");
        boolean result = true;
        setList(list,16,19);
        result = result && test(list.indexOf(0,new Long(17))==1,"indexOf(0,E): OK","indexOf(0,E): failed");
        result = result && test(list.indexOf(1,new Long(17))==1,"indexOf(1,E): OK","indexOf(1,E): failed");
        result = result && test(list.indexOf(2,new Long(17))==-1,"indexOf(2,E): OK","indexOf(2,E): failed");
        result = result && test(list.indexOf(0,new Long(9))==-1,"indexOf(0,E): OK","indexOf(2,E): failed");
        return result;
    }
    
    private static boolean testIterator(List<Long> list) {
        System.out.println("------iterator()------------------");
    	setList(list,15,19);
        long[] arr = new long[list.size()];
        Iterator<Long> iter = list.iterator();
        int index=0;
        while(iter.hasNext()) {
            arr[index] = iter.next();
            index++;
        }
        test(sameMembers(list,new long[]{15,16,17,18,19}),"iterator(): OK", "iterator(): failed");
    	return false;
    }
    
    private static void testList(ListFactory factory) {
		if (testSizeAddGet(factory.getList())) {
			testAddPos1(factory.getList());
			testAddPos2(factory.getList());
			testAddFirst(factory.getList());
			testAddLast(factory.getList());
			testClear(factory.getList());
			testSet(factory.getList());
			testRemovePos(factory.getList());
			testRemoveFirst(factory.getList());
			testRemoveLast(factory.getList());
			testIndexOf(factory.getList());
			testIndexOfPos(factory.getList());
			testIterator(factory.getList());
		}
   }

    // --------  Testmetod fÃ¶r Stack  ---------------------------------------
    private static void testStack(Stack<Long> stack) {
        System.out.println("------Stack------------------");
        test(stack.size()==0, "size(): OK", "size(): Initial size failed");        
        test(stack.isEmpty(), "empty(): OK", "empty(): failed on empty stack");        
        stack.push(8L);
        stack.push(10L);
        test(stack.size()==2, "push(element)/size(): OK", "push(element)/size(): Wrong size");
        stack.push(12L);
        test(stack.peek()==12,"peek(): OK", "peek(): Wrong element on top");
        test(stack.size()==3, "peek(): OK", "peek(): Wrong size after peek");
        test(stack.pop()==12, "pop(): OK", "pop(): Wrong value");
        test(stack.size()==2, "pop()/size(): OK", "pop()/size() Wrong size after pop");
        test(!stack.isEmpty(), "empty(): OK",  "empty(): failed on not empty stack");
        test(stack.pop()==10, "pop(): OK","pop(): Element!=10");
        test(stack.pop()==8, "pop(): OK","pop(): Element!=8");
        test(stack.isEmpty(), "empty(): OK", "empty(): failed on empty stack");        
    }
    
    // --------  Testmetod fÃ¶r sÃ¶kning/sortering  ---------------------------------------
    public static void testSearchSort() {
        System.out.println("------Searching/sorting------------------");
        ArrayList<Long> list = new ArrayList<Long>();
        setList(list, 50, 79);
        int pos = Searching.binearSearch(list, new Long(60));
        test(pos==10, "binarySearch(): OK", "binarySearch(list,60)=="+pos);
        pos = Searching.binearSearch(list, new Long(100));
        test(pos<0, "binarySearch(): OK", "binarySearch(list,100)=="+pos);
        shuffle(list);
        System.out.println(strList(list));
        double[] arr = new double[list.size()];
        for(int i=0; i<arr.length; i++)
            arr[i] = list.get(i);
        test(Searching.linearSearch(list, new Long(60))>=0, "linearSearch(): OK", "linearSearch(list,60)==-1");
        test(Searching.linearSearch(list, new Long(100))==-1, "linearSearch() OK", "linearSearch(list,100)>=0");
        Sorting.sort(list);
        System.out.println(strList(list));
        Sorting.sort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
    private static int getChoice(String[] menu) {
        String str = "";
        int choice=-1;
        for(int i=0; i<menu.length; i++) {
            str += menu[i] + "\n";
        }
        try {
            choice = Integer.parseInt(JOptionPane.showInputDialog(str));
        }catch(Exception e) {}
        return choice;
    }

	public static void main(String[] args) {
	    String[] menu = {"1. ArrayList<Long>()", "2. ArrayList<Long>(2)", "3. LinkedList<Long>()", "4. ArrayStack<Long>(10)","5. Searching, Sorting", "0. Exit"};
	    int choice = getChoice(menu);
	    while(choice != 0) {
	        switch(choice) {
	        case 1 : testList(new AL0()); break;
	        case 2 : testList(new AL2()); break;
	        case 3 : testList(new LL()); break;
	        case 4 : testStack(new ArrayStack<Long>(10)); break;
	        case 5 : testSearchSort(); break;
	        }
	        choice = getChoice(menu);
	    }
	}
}


interface ListFactory {
	public List<Long> getList();
}

class AL0 implements ListFactory {
	public List<Long> getList() {
		return new ArrayList<Long>();
	}
}

class AL2 implements ListFactory {
	public List<Long> getList() {
		return new ArrayList<Long>(2);
	}
}

class LL implements ListFactory {
	public List<Long> getList() {
		return new LinkedList<Long>();
	}
}