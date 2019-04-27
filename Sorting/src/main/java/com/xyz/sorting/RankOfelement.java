package com.xyz.sorting;


/* Given an unsorted array of element find a element of rank K (Kth smallest element in an array
*  e.g.  [7,4,1,5,3,13,5,0]
*   Rank of 0 is 1, 3 is 2 and 13 in N.
*  Start with no duplicate.
*/

/* Solution : Can be solved using a subset of quick sort , where start with the element's index
              as pivot and use partition to find new pivot, which is the rank of the element.

  Naive approach: Sort the entire array and find the index. It should work.
 */

public class RankOfelement {

    public static void swap(int a[], int s, int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }

    public static int partition (int a[], int start, int end, int pivot) {

        /* Move the pivot element to end of the array.
           Partition and current are initialized to 0.
           Run through array, move the element (it less than pivot) to left of partition and move the partition.
           move the end element to partition.
         */

        int current = 0,  partition = 0;

        swap(a,end,pivot);

        for (current = 0; current < end; current++) {
            if (a[current] < a[partition]) {
                swap(a,current,partition);
                partition++;
            }
        }

        swap(a,end,partition);

        return partition+1  ;
    }

    public static int getIndex(int a[], int q) {

        int pivot = 0;
        for (int i=0; i<a.length; i++) {
            if (a[i] == q) {
                pivot = i;
                break;
            }
        }

        return pivot;
    }

    public static void main (String [] args){
        int a[] = {7,4,1,9,3,13,5,0};

        int pivot = getIndex(a,5);

        pivot = partition(a,0,a.length-1, pivot);
        for (int i = 0; i< a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        System.out.println("Rank of 5 is " + pivot);
    }
}
