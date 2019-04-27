package com.xyz.sorting;


/* Given two teams having equal number of players (of different or same height). For photograph to be taken make sure
all people should be visible in the photograph. i.e. tallest person should stand in back. Players in same team should
stand in same row.
*/

/*
Solution:
Its equivalent to having 2 unsorted arrays , iterate through sorted arrays and check if ai is greater than bi. Solution
just returns a boolean if team in front is over shadows on in the back.
*/


public class TeamPhoto {

    static void swap(int a[], int s, int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }


    static int partition(int a[], int start, int end, int pivot) {

        int partition = start;
        swap(a,end,pivot);
        for (int i = start; i < end; i++) {
            if (a[i] < a[end]) {
                swap(a,i,partition);
                partition++;
            }
        }
        swap(a,end,partition);
        return partition;
    }


    static void  sort(int a[], int start, int end) {

        if ( start > end ) return;
        if (start == end ) return;

        int pivot = start + (end - start) / 2;
        int newPivot = partition(a, start, end, pivot);
        sort(a, 0 , newPivot-1);
        sort(a, newPivot+1, end);

    }

    static void print (int a[]){
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static boolean checkSize(int front[], int back[]) {
        int i = 0, j = 0;

        while(i<front.length && j < back.length) {
            if (front[i] >= back[j])  {
                System.out.println(front[i] + " " + back[j]);
                return false;
            }
            i++;j++;
        }

        return true;
    }

    public static void main (String[] args) {

        int teama[] = {8,14,1,10,2,0,2};
        int teamb[] = {3,1,3,113,11,17,2};
        print(teama);
        sort(teama,0,teama.length-1);
        sort(teamb,0,teamb.length-1);
        print(teama);
        print(teamb);
        System.out.println("Can take photo " + checkSize(teama, teamb));
        System.out.println("Can take photo " + checkSize(teamb, teama));

    }

}
