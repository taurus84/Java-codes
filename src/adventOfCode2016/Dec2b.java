package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by David on 2016-12-02.
 */
public class Dec2b {

    private static int[][] SM = {  
                            {1,3,4,2},
                            {2,6,3,2},
                            {1,7,4,2},
                            {4,8,4,3},
                            {5,5,6,5},
                            {2,10,7,5},
                            {3,11,8,6},
                            {4,12,9,7},
                            {9,9,9,8},
                            {6,10,11,10},
                            {7,13,12,10},
                            {8,12,12,11},
                            {11,13,13,13}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("src/adventOfCode2016/dec2.txt"));
        String s;
        int latestFoundDigit = 5;
        char c;
        int col = 0;
        while ((s = r.readLine()) != null) {
            for(int i = 0; i < s.length(); i++) {
            	c = s.charAt(i);
            	if		(c == 'U')	col = 0;
            	else if	(c == 'D')	col = 1;
            	else if	(c == 'R')	col = 2;
            	else if	(c == 'L')	col = 3;
                latestFoundDigit = SM[latestFoundDigit-1][col];
            	
            }
            System.out.println(latestFoundDigit);
        }

    }


}


