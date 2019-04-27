package com.xyz.sorting;

import java.util.Arrays;

public class MergeSort {


    public static void merge(int a[], int start, int mid, int end) {

        int ln = mid - start+1 ;
        int rln = end - mid;

        int left[] = new  int [ln] ;
        int right[] = new int [rln];

        int p = 0, q = 0;

        for (int i = 0;i<ln;i++) {
            left[i] = a[start+i];
        }

        for (int i = 0; i< rln; i++) {
            right[i] = a[mid + i+1];
        }

        int i = start;
        while (p < ln && q< rln) {

            if (left[p] < right[q]) {
                a[i++] = left[p++];
            }else {
                a[i++] = right[q++];
            }

        }

        while(p<ln) {
            a[i++] = left[p++];
        }

        while(q<rln) {
            a[i++] = right[q++];
        }


    }

    public static void sort (int a[], int start, int end) {

        if (start >= end) return;

        int mid = start + (end - start)/2;

        System.out.println( "Start : " + start + " " + mid +  "  " + end);
        sort (a, start,mid);
        sort (a,mid + 1, end);
      //  print(a, "R " + start + " " + mid + " " + end);
        merge(a,start,mid,end);
    }


    public static void print (int a[], String s) {
        System.out.println(s);
        for (int i = 0; i<a.length; i++)
             System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args ){
        int a[] = {9,1,7,6,89,2,9};
        print(a,"Before");
        sort(a,0,a.length-1);
        print(a,"After");
    }
}
