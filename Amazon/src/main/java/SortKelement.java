import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class SortKelement {


    static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    static int partition(int array[], int start, int end, int pivot) {

        int p = array[pivot];
        swap(array, pivot,end);

        int newpivot = start;

        for (int i=start;i<end;i++) {
            if (array[i] < p) {
                swap(array,i,newpivot);
                newpivot++;
            }
        }

        swap(array,end,newpivot);
        return newpivot;
    }

    /*
    1,4,6, 7, 9,8,10  k=4  np =2

    np < k
     Just worry about right half.

    np >k
     just worry about left half.


    np = k
        return;
    */


    public static void sort(int[] array,int start, int end,int k) {

        if (start>=end) return;
        int pivot = ThreadLocalRandom.current().nextInt(start,end);
        int newpivot = partition (array, start, end, pivot);

        if (newpivot == k) return;

        if (newpivot < k) {
            sort(array,newpivot+1, end,k);
        } else {
            sort(array, start, newpivot - 1, k);
        }
       // sort(array,newpivot+1, end,k);

    }


    public static void main(String args[]) {

        int a[] = {31,4,1,15,10,2};

//        Arrays.stream(a).forEach(System.out::println);

        sort(a,0,a.length-1,1);
        Arrays.stream(a).forEach(System.out::println);

    }

}
