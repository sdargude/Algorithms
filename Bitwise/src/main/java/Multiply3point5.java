/*
Problem:
Multiply a given number by 3.5 , without using + , *, / ++ operator and return integer.


Solution:

    3.5 times a number X is

        2X + X + X/2 = 3.5X.

        2X is X<<1;
        X/2 is X>>1
*/

public class Multiply3point5 {

    public static int multiply3point5 (int x) {
        return (x<<1) + x + (x>>1);
    }

    public static void main(String args[]){
        System.out.println(multiply3point5(2));
    }
}
