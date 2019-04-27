package com.xyz.sorting;


/* Problem: Sort 256 Billion integers saved in a file, using 16gb ram machine

 Approach : Break the input file, sort and store the chunks in seperate files

              Following table would help to find number of bits in the file
              ^ -> Raise to.

                2 ^ 10  ~= 10 ^ 3  (1 Kilo).
                2 ^ 20  ~= 10 ^ 6  (1 Mega).
                2 ^ 30  ~= 10  ^ 9 (1 Giga).

                16 gb = 16 * 1 gb
                      = 2 ^ 4 * 2 ^ 30 * 2 ^ 3 = 2 ^ 37 bits.
                         (16)   (1gb)     (bits)

                256 billion integers (32 bytes) =
                  2 ^ 8  *  10  ^ 9  * 2 ^ 3

                  = 2 ^ 8 * 2 ^ 30 * 2 ^ 3 = 2 ^ 41




                  Use external merge sort for sorting the sorted chunk, keep counters per file and follow merge procedure.
                  One can do two file at time, if number of files are too big to run out the file descriptor


 Following solution is a micro version of the bigger problem,

 Problem: Given multiple sorted list, print an sorted list.

 e.g. a[][]= {
        [1,3,5],
        [2,6],
        [9,10]
        }
  print -> 1,2,3,5,6,9,19.


 */

public class SortBillionIntegers {

    public static void printSorted (int a[][]) {
        int pointers[] = new int[a.length];
        int totalelements = 0;

        for (int i = 0; i< a.length; i++) {
            totalelements += a[i].length;
            pointers[i]=0;
        }

        int counter = 0;

        while(counter < totalelements) {
            int element = Integer.MAX_VALUE;
            int curindex = 0;
            int index = 0;

            for (int i = 0; i < a.length; i++) {
                    curindex = pointers[i];
                    if (curindex < a[i].length && a[i][curindex] <  element){
                        element = a[i][curindex];
                        index = i;
                    }
            }
            System.out.print (element + " ");
            pointers[index]++;
            counter++;
        }

        System.out.println();

    }

    public static void main(String [] args){

        int a[][] = {
                    {1,3,5,11},
                    {2,6,7},
                     {9,10,90}
        };

       // System.out.println(a[0].length);
        printSorted(a);


    }

}
