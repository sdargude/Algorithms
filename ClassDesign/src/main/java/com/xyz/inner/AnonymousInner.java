package com.xyz.inner;

public class AnonymousInner {

    interface ImplementMe {
        int mymethod();
    }


    public ImplementMe returnsomething() {
        return ( new ImplementMe() {
            public int mymethod() { return 3; }
        }
        );
    }

    public static void main(String [] args ){
        AnonymousInner a = new AnonymousInner();
        System.out.println(a.returnsomething().mymethod());
    }
}

