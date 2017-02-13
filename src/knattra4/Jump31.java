package knattra4;

/**
 * Created by davidtran on 2017-02-01.
 */
public class Jump31 {

    //long[] arr = new long[] {1,2,3,4,5,6,7,8,9};
    long[] arr = new long[] {1,2,3};

    int pointer = 0, jumps;
    long jumpNbr;


    public void run() {
        while(check()) {
            if(jumps == 144) {
                System.out.print("hej");
            }
            jumpNbr = arr[pointer];
            if(arr[pointer]%2 != 0) {
                arr[pointer] = arr[pointer]*3 - 1;
                pointer = (int)((pointer + jumpNbr)%9);
            } else {
                arr[pointer] = arr[pointer]*3 + 1;
                jumpNbr = jumpNbr%9;
                if(pointer- jumpNbr < 0) {

                    pointer = (int)(pointer - jumpNbr + 9);
                } else {
                    pointer -= jumpNbr;
                }
            }

            if(pointer < -8) {
                System.out.print("oh oh");
            }
            jumps++;
            System.out.println(jumps);
        }
        System.out.print(jumps);
    }

    public boolean check() {
        for(int i = 0; i < arr.length; i++) {
            if(i%2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Jump31 j = new Jump31();
        j.run();
    }
}
