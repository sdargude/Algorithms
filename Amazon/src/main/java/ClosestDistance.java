
/* Problem:
    Find a k - closest points to the origin form give a set of points.

    distance from orgin is SQRT (x * x + y * y).
 */

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;



class Solution {
    public long euclideanDistance (int[][] a, int index) {
        return a[index][0]*a[index][0] + a[index][1]*a[index][1];
    }

    public void swap(int[][]array,int i, int j) {
        int temp[]=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    int partition (int [][] array, int start, int end, int pivot) {

        swap(array,pivot,end);
        long distance = euclideanDistance(array,end);


        int part = start;

        for (int i=start;i<end;i++){
            if (euclideanDistance(array,i) < distance){
                swap(array,i,part);
                part++;
            }
        }

        swap(array,part,end);

        return part;
    }

    public void sort (int a[][], int start, int end, int K) {

        if (start >= end) return;

        int pivot = ThreadLocalRandom.current().nextInt(start,end);

        int newpivot = partition(a, start, end, pivot);

        if(newpivot == K) return;

        if (newpivot < K) {
            sort(a,newpivot+1,end,K);
        }else {
            sort(a,start,newpivot-1,K);
        }

        return;
    }

}


public class ClosestDistance {

    public static void print(int[][]args) {
        for (int i=0;i<args.length;i++) {
            System.out.println(args[i][0] + " " + args[i][1]);
        }
    }

    public static void main(String [] args){
        int [][] points={{1,3},{-2,2},{1,1},{1,4},{2,2}};


  //      print(points);
        Solution s = new Solution();
        s.sort(points,0,points.length-1,3);
        print(points);


        Arrays.sort(points, (x,y)->{
                int disa=x[0]*x[0] + x[1]*x[1];
                int disb=y[0]*y[0] + y[1]*y[1];
                return Integer.valueOf(disa).compareTo(disb);
            });

    //    print(points);




//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int a[], int b[]) {
//
//                int dista = a[0] * a[0] +  a[1] *a[1];
//                int distb = b[0] * b[0] + b[1] * b[1];
//                return Integer.valueOf(dista).compareTo(distb);
//            }
//        });
//



    }
}
