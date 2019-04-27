/*
Problem: Add one to a given number without using +,*,-,/, ++, --;


Solution:

    Flip the bits after rightmost zero.
    Flip the right most zero.

    e.g. X = 5 : 0101
    X + 1 = 6  : 0110


    Algorithm:


      X        M            &             ^

     0101     0001          1           0100
     0100     0010          0           Break (step1)


     Step2 : Flip the right most zero, we already have mask 0010.

     0100 ^ 0010  : 0110


 */

public class AddOne {

    public static int addOne(int x){
        int m = 1;

        while ((int)(x & m) == 1) {
            x = x ^ m;
            m=m<<1;
        }

        x = x ^ m;
        return x;
    }

    public static void main(String args[]) {
        System.out.println(addOne(5142));

    }
}
