package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Dec4 {
	
	 public static void main(String[] args) throws IOException {
		  BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec4.txt"));
	        String s;
	        while ((s = r.readLine()) != null) {
	        	String[] splitString = s.split("-");
	        	LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	        	for(int i = 0; i < splitString.length-1; i++) {
	        		for(int j = 0; j < splitString[i].length(); j++) {
	        			char key = splitString[i].charAt(j);
		        		if(map.containsKey(key)) {
		        			int value = map.get(key);
		        			map.put(key, map.get(key) + 1);
		        		} else {
		        			map.put(key, 1);
		        		}
	        			
		        	}
	        	}
	        	//sortera map
	        	
	        	
	        }
	 }

}
