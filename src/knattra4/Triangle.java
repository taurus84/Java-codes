package knattra4;

/**
 * Created by davidtran on 2017-02-01.
 */
public class Triangle {
    long counter = 1, checkNbr = 0;
    boolean running = true;

    public void run() {
        while(running) {
            checkNbr += counter;
            counter++;
            divisers(checkNbr);
        }
    }


    public void divisers(long nbr) {
        int divisers = 0;
        for(int i = 1; i <= nbr; i++) {
            if(nbr%i == 0) {
                divisers++;
            }
            if(divisers > 100) {
                System.out.println(nbr);
                running = false;

            }
        }
    }
    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.run();
    }




}
