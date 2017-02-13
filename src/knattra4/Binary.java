package knattra4;

/**
 * Created by davidtran on 2017-02-01.
 */
public class Binary {

    public void run() {
        String bin = "", nbr;
        long counter = 0;
        for(long i = 0; i <= 2147483647; i++) {
            if(i%100000000 == 0) {
                System.out.println("Now checking: " + i);
            }

            bin = Long.toBinaryString(i);

            nbr = i + "";
            if(bin.contains(nbr)) {
                counter++;
            }
        }
        System.out.print(counter);
    }

    public static void main(String[] args) {
        Binary b = new Binary();
        //System.out.print(Integer.toBinaryString(10));

        b.run();

        //....7.6.5.....4.8.2....6.7...3...2..5.......4..4....6..8.4....3...2.....7.6.8....
    }
}
