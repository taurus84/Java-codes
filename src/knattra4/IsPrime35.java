package knattra4;

import helper.IsPrime;

/**
 * Created by davidtran on 2017-02-01.
 */
public class IsPrime35 {

    public void run() {
        long sum = 0;
        for(int i = 4996; i < 6495; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }
        System.out.print(sum);
    }

    public boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        IsPrime35 a = new IsPrime35();
        a.run();

    }
}

