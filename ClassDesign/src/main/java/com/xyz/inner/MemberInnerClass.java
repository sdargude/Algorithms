package com.xyz.inner;

public class MemberInnerClass {

    private String grettings = "Hi";
    private int x = 10;

    class InnerClass {
        private int x = 12;
        InnerClass() {
            System.out.println("Inner Classs got instantiated!");
        }

        void go(){
            for (int i=0; i<3;i++)
                System.out.println("Grettings from Inner " + grettings + " " + x + " " + MemberInnerClass.this.x);
        }
    }

    public void callInner() {
        InnerClass inner = new InnerClass();
        inner.go();
    }

    public static void main(String [] args) {
        MemberInnerClass m = new MemberInnerClass();
        m.callInner();

        System.out.println("From Inner class reference!");
        InnerClass i = m.new InnerClass();
        i.go();
    }


}
