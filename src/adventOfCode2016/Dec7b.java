package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dec7b {
	
	public static void main(String[] args) throws IOException {

		 BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec7.txt"));
		 String s;
		 int counter = 0;
		 /* för varje [ finns en ] */
		 while((s = r.readLine()) != null) {
			 ArrayList<String> supernet = new ArrayList<String>();	//outside square brackets
			 ArrayList<String> hypernet = new ArrayList<String>();	//inside square brackets
			 String[] splitString = s.split("\\[");
			 supernet.add(splitString[0]);
			 for(int i = 1; i < splitString.length; i++) {
				 String[] split2 = splitString[i].split("\\]");
				 hypernet.add(split2[0]);
				 supernet.add(split2[1]);
			 }
			 if(aba(supernet, hypernet)) 
				 counter++;
		 }
		 System.out.println(counter);
	        
	}
	
	public static boolean aba(ArrayList<String> supernet, ArrayList<String> hypernet) {
		String subHyper, subSuper;
		char a,b,c, a1,b1,c1;
		for(int i = 0; i < hypernet.size(); i++) {
			subHyper = hypernet.get(i);
			for(int j = 1; j < subHyper.length() - 1; j++) {
				b = subHyper.charAt(j);
				a = subHyper.charAt(j-1);
				c = subHyper.charAt(j+1);
				if(a == c && a != b) {	//found a valid serie aba, check if the reverse can be found in supernet
					for(int k = 0; k < supernet.size(); k++) {
						subSuper = supernet.get(k);
						for(int m = 0; m < subSuper.length() -2; m++) {
							a1 = subSuper.charAt(m);
							b1 = subSuper.charAt(m+1);
							c1 = subSuper.charAt(m+2);
							if(a1 == b && b1 == a && c1 == b) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
