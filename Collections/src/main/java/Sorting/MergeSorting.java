package Sorting;

import com.sun.scenario.effect.Merge;

public class MergeSorting {


    void merge(int [] a, int start, int mid, int end) {

        int len_left =  mid - start +1;
        int len_right = end - mid;


        int left[] = new int[len_left];
        int right[] = new int[len_right];

        for (int i = 0;i<len_left;i++) {
            left[i] = a[start+i];
        }

        for(int i=0; i<len_right; i++) {
            right[i] = a[mid+i +1];
        }

        System.out.print ("Left : "  );
        for (int x: left) System.out.print( " " + x );

        System.out.print("  Right : ");
        for (int x: right) System.out.print(" " + x);
        System.out.println();



        int j=0, i=0, k=0;
        for (i=start;i<end;i++){
            if (j >= len_left  || k >= len_right) break;
                a[i] = left[j];
                if (left[j] < right[k]) {
                    a[i] = left[j];
                    j++;
                } else {
                    a[i] = right[k];
                    k++;
                }

            }


        while(j<len_left){
            a[i] = left[j];
            i++;j++;
        }

        while(i<len_right){
            a[i] = right[k];
            i++;k++;
        }

        for (int p: a)
            System.out.print(p + " ");
        System.out.println();
    }


    void mergesort(int []a, int start, int end) {
     //   if (start >= end) return;
       if (start < end) {
           int mid = start + (end - start) / 2;
           System.out.println("Start " + start + " Mid " + mid + " End " + end);
           mergesort(a, start, mid);
           mergesort(a, mid + 1, end);
           merge(a, start, mid, end);
       }
    }

    public static void main(String [] wtr){
       //int array[] = {12,2,123,4,1,13,345,12};
        int array[] = {534,251,43};

        MergeSorting s = new MergeSorting();
        for (int a: array)
            System.out.print(a + " ");
        System.out.println();
        s.mergesort(array,0, array.length-1);
        for (int a: array)
            System.out.print(a + " ");
        System.out.println();
    }
}
