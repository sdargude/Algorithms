package com.xyz.sorting;

/* Problem: Given to arrays of integers which are sorted.  Find if one is subset of another.
 E.g [0,1,2,3] , [1,2] : Yes
     [0,1,2], [] : Yes
     [0,1,2], [2,3,4] : No.
*/

/* Solution: Brute force approach would be M * N for loops and check if there is anything not present
   Optimized solution can be  one used in merge sort in merge stage.

    In merge state:  elements from each array is inserted in an new array, till either one of the earray exhausts.

    We can maintain an counter, which will be incremented when both array element matches, else increase pointers of
    respective arrays. Do not drain remaining elements of arrays.

    If counter = min (a.lenght, b.length), it means it was a subset.

 */

public class FindSubSet {

    /* This is same as merge function in merge sort */
    public static boolean isSubset(int a[], int b[]) {

        int i = 0, j = 0, counter = 1;
        int alen = a.length;
        int blen = b.length;

        while (i < alen && j <blen) {

            if (a[i] == b[j]) {
                counter++;
                i++;j++;
            }

            if (a[i] < b[j]) { i++;}
            else j++;
        }

        return counter == Math.min(alen,blen);

    }

    public static void main(String[] args) {
        int a[] = {0,1,2,3};
        int b[] = {1,2};
        if (a.length == 0 || b.length == 0) System.out.println(true);
        else System.out.println(isSubset(a,b));
    }

}
