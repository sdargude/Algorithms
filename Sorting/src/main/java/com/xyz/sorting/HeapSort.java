package com.xyz.sorting;

public class HeapSort {

    /*
        presenting a Binary tree as Array.
        If a Node is at index - i
        it's left child is at - 2 * i
        its right child is at - 2 * i + 1
        it's parernt is at - i/2
    */

    public static void swap (int a[], int s, int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }

    public static void heapify(int a[], int current) {

        while ( a[current] < a[(current)/2]){
            swap (a, current, (current)/2);
            current = (current)/2;
        }
    }


    public static void print (int a[], String message){
        System.out.print (message + ":");
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void heapdown (int a[], int size, int current) {

        int left=0, right = 0;

        while (current < size) {
            left = 2 * current;
            right = 2 * current + 1;
            if ( left < size && a[left] < a[current]) {
                swap(a,left,current);
                current = left;
            } else if (right <size && a[right] < a[current]) {
                swap(a,right,current);
                current=right;
            }else {
                break;
            }
        }

    }

    public static void sort(int a[]) {

        for (int i = 1; i< a.length; i++) {
            heapify(a, i);
        }

        System.out.println("After Heapify");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = a.length - 1; i >= 0 ; i--) {
            swap(a,i,0);
            heapdown(a,i,0);
        }

        print(a,"Reversed");

        int end = a.length -1;
        for (int i=0;i <=end/2  +1; i++) {
            swap(a,i,end);
            end--;
        }
    }

    public static void main(String [] args ){
        int a[] = {4,11,9,2,7};
        print(a,"Before");
        sort(a);
        print(a,"After");

    }

}
