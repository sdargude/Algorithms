package com.xyz.inner;

public class LocalInnerClass {

    private int length = 5;
    public int calculate() {
        final int widht = 20; /* widht should be final or effective final */
        class Inner {
            public int multiply(){
                System.out.println(length * widht);
                return length * widht;
            }
        }

        Inner i = new Inner();
        return i.multiply();
    }


    public static void main(String [] args){
        LocalInnerClass l = new LocalInnerClass();
        System.out.println(l.calculate());

    }
}
