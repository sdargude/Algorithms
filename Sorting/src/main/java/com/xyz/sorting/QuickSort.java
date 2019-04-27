package com.xyz.sorting;

import sun.awt.geom.AreaOp;

import java.util.Arrays;

public class QuickSort {

    public static int getPivot(int start, int end ){
        return start + (end-start)/2;
    }

    public static void qsort (int [] a, int start, int end, int pi) {

        if (start > end) return;
        if (start == end) return;

        int new_pivot = partition(a,start,end,pi);
        qsort(a,start,new_pivot,getPivot(start,new_pivot-1));
        qsort(a,new_pivot+1, end, getPivot(new_pivot+1, end));
    }

    public static int partition(int []a, int start, int end, int pi) {

        int temp = a[pi];
        a[pi] = a[end];
        a[end]=temp;

        int part = start;

        for (int i=start;i<end;i++){
            if (a[i] < a[end]) {
                temp = a[part];
                a[part] = a[i];
                a[i] = temp;
                part++;
            }
        }

        temp = a[part];
        a[part]=a[end];
        a[end] = temp;
        return part;
    }

    public static void main (String []args ){
        int a[] = {3,7,8,2,7,9,20,19,3};

        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
        qsort(a,0,a.length-1, (a.length -1)/2);
        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
        System.out.println();

        }

}
