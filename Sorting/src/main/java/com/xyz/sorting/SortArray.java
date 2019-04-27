package com.xyz.sorting;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;

public class SortArray {



    public static void main(String args[]) {

        int d[][]={ {1,2},{23,12},{12,1},{43,123},{34,13}};


        System.out.println("Before : ");
        for (int i=0; i<d.length;i++) {
            System.out.println(d[i][0] + " " + d[i][1]);
        }

        Arrays.sort(d,(a,b)->a[0]>b[0]?1:-1);
        System.out.println();
        System.out.println("After: ");

        for (int i=0; i<d.length;i++) {
            System.out.println(d[i][0] + " " + d[i][1]);
        }


        Stack<Character> stack = new Stack<>();

        int a [] =  {1,2,3,};
        List<Integer> list = Arrays.asList(a);

        TreeMap<String, String> tmap = new TreeMap<>();


    }

}
