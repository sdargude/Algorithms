package com.xyz.sorting;
/*
    Given an infinite stream of Integers (non-sorted), every time one sees a marker (say no. 404) print k largest number.

    e.g. 90,30,60, 4,3, 404,9,23,12,1,3,404.  and for K = 3.

    One first occurence of 404, print 90,30,60.
    One Second occurence of 404, print 23,12,9
 */

/*
    Solution: Brute force approach is maintain array of size K. have Max and Min variables, if incoming variable is
     larger than min, then replace min with integer. If there empty slot in array add new element to array and adjust min.

     Optimized way can be to maintain an sorted array, so that min can be replace with o(1).
     use min-heap for keeping maintaining min heap.
 */

public class InfiniteStream {

    int [] array;
    int size;
    int currentsize;
    final int marker;

    InfiniteStream (int size, int marker) {
        this.size = size;
        currentsize = 0;
        this.marker = marker;
        array = new int[size];
    }

    void swap(int s, int d) {
        int temp = array[s];
        array[s] = array[d];
        array[d] = temp;
     }

    void insert(int num) {
        if (num == marker) {
            print();
            currentsize = 0;
            return;
        }

        if (currentsize == size) {
            if(num > array [0]) delete();
            else return;
        }

        int last = currentsize;
        array[currentsize] = num;

        while(array[last/2] > array[last]) {
            swap(last, last/2);
            last = last/2;
        }
         currentsize++;
    }


    void delete() {
        array[0] = array[currentsize-1];
        for (int i = 0; i < currentsize; i++) {
            if (2 *i < size && array[2*i] < array[i]) {
                swap(i,2*i);
                i = 2 * i;
            }else if (2 *i+1 < size && array[2 * i + 1] < array[i]){
                swap(i,2*i+1);
                i = 2 * i  + 1;
            }
        }
        currentsize--;
    }


    void print() {
        for (int i = 0; i < currentsize; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }


    public static void main(String [] args) {
        InfiniteStream is = new InfiniteStream(5,404);

        is.insert(10);
        is.insert(8);
        is.insert(3);
        is.insert(6);
        is.insert(1);
        is.print();
        is.insert(404);
        is.insert(20);
        is.insert(31);
        is.insert(12);
        is.insert(41);
        is.insert(631);
        is.insert(14);
        is.print();

    }
}
