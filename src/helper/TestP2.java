package helper;

import javax.swing.JOptionPane;

/**
 * The class tests the class DoubleLinkedList, and all methods in it, with help from an option dialogue window. 
 * 
 * @author David Tran
 * Date: March 4th 2015
 *
 */
public class TestP2 {

	private static DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
	
	/**
	 * The method tests methods in class DoubleLinkedList. 
	 * Methods tested are: add(), addFirst(), addLast()
	 */
	public static void add() {
		String data;
		int index;
		String menu = "Choose which method to be executed:\n\n"
				+ "1.  add(int index, Object data)\n" + "2.  addFirst()\n"
				+ "3.  addLast()\n" + "------------------------------\n" 
				+ "0.  Close window\n\n" + "Make your choice";
		int choice = -1;
		while (choice != 0) {
			try {
				switch (choice) {
				case 1:
					index = Integer.parseInt(JOptionPane.showInputDialog("On which index in line?\n"
							+ "Maximum index is " + (list.size())));
					if(index > list.size()) {
						JOptionPane.showMessageDialog(null, "I told you the maximum index...");
					} else {
						data = JOptionPane.showInputDialog("Who wants to get in line?");
						list.add(index, data);
						System.out.println(list);
					}
					break;
				case 2:
					data = JOptionPane.showInputDialog("Who shall be put first in line?");
					list.addFirst(data);
					System.out.println(list);
					break;
				case 3:
					data = JOptionPane.showInputDialog("Who wants to get in line?");
					list.addLast(data);		
					System.out.println(list);
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
//				System.out.println(e);
				choice = -1;
			}
		}
	}
	
	/**
	 * The method tests methods in class DoubleLinkedList. 
	 * Methods tested are: remove(), removeFirst(), removeLast()
	 */
	public static void remove() {
		int index;
		String menu = "Choose which method to be executed:\n\n"
				+ "1.  remove(int index)\n" + "2.  removeFirst()\n"
				+ "3.  removeLast()\n" + "------------------------------\n"
				+ "0.  Close window\n\n" + "Make your choice";
		int choice = -1;
		while (choice != 0) {
			try {
				switch (choice) {
				case 1:
					index = Integer.parseInt(JOptionPane.showInputDialog("Remove on what index?\n"
							+ "Maximum index is " + (list.size() - 1)));
					if(index > (list.size() - 1)) {
						JOptionPane.showMessageDialog(null, "I told you the maximum index...");
					} else {
						list.remove(index);
						System.out.println(list);
					}
					
					break;
				case 2:
					list.removeFirst();
					System.out.println(list);
					break;
				case 3:
					list.removeLast();
					System.out.println(list);
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
//				System.out.println(e);
				choice = -1;
			}
		}
	}
	
	public static void get() {
		int index;
		String menu = "Choose which method to be executed:\n\n"
				+ "1.  get(int index)\n" + "2.  getFirst()\n"
				+ "3.  getLast()\n" + "------------------------------\n"
				+ "0.  Close window\n\n" + "Make your choice";
		int choice = -1;
		while (choice != 0) {
			try {
				switch (choice) {
				case 1:
					index = Integer.parseInt(JOptionPane.showInputDialog("On which index would you want to look at?"));
					System.out.println(list.get(index));
					break;
				case 2:
					System.out.println(list.getFirst());
					break;
				case 3:
					System.out.println(list.getLast());
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
//				System.out.println(e);
				choice = -1;
			}
		}
	}
	
	/**
	 * Main method of the class. Using different cases depending on user input. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String menu = "Choose which method to be executed:\n\n"
				+ "1.  Add to queue\n" + "2.  Remove from queue\n"
				+ "3.  Get from queue\n" + "4.  Show queue and size\n" 
				+ "5.  Clear queue\n"	
				+ "------------------------------\n" + "0.  Quit programme\n\n" + "Make your choice";
		int choice = -1;
		while (choice != 0) {
			try {
				switch (choice) {
				case 1:
					add();
					break;
				case 2:
					if(list.size() == 0) {
						JOptionPane.showMessageDialog(null, "Nothing to remove!");
					} else {
						remove();
					}
					break;
				case 3:
					get();
					break;
				case 4:
					System.out.println(list + "\tNumber in line = " + list.size());
					break;
				case 5:
					list.clear();
					System.out.println("You cleared the queue");
					break;
				case 6:
					System.out.println("case6");
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
				System.out.println(e);
				choice = -1;
			}
		}
		
		
		
		
	}
}
