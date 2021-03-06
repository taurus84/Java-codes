package adventOfCode2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by David on 2016-12-02.
 */
public class Dec2 {

    private static int[][] SM = {  {1,4,2,1},
                            {2,5,3,1},
                            {3,6,3,2},
                            {1,7,5,4},
                            {2,8,6,4},
                            {3,9,6,5},
                            {4,7,8,7},
                            {5,8,9,7},
                            {6,9,9,8}
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


