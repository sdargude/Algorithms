package Pattern5;

/*
Given a number sequence, find the length of its Longest Increasing Subsequence (LIS). In an increasing subsequence, all the elements are in an increasing order (from lowest to highest).

Example 1:


Input: {4,2,3,6,10,1,12}
Output: 5
Explanation: The LIS is {2,3,6,10,12}.


Solution:

1. Starting from every index call following function and find max value

        int func(int a[], int index){

                int count = 0;
                int prev = index;
                for (int i=index;i<a.len;i++){
                    if a[i] > a[prev]
                        count++;

                    prev = i;
                }

                return count;
        }

        O (N * N).


 2. Recursive Solution:

        start: index=0, prev = -1;

        int func ( int a[], int index, int prev){

            int c1=0;
            if (if (prev== -1 || a[index] > a[prev])
                c1 = 1 + fun(a, index+1, index);


            c2 = func(a, index+1, prev);

            return Math.max(c1,c2);

        }

        2 ^ N.




 */



public class LongestIncreasingSequence {

    public static int lcssr (int a[], int index, int prev) {

        if (index == a.length) return 0;

        int c1 = 0;
        if (prev == -1 || a[index] >= a[prev]) {
            c1 = 1 + lcssr(a,index+1,index);
        }

        int c2 = lcssr(a,index+1,prev);
        return Math.max(c1,c2);
    }


    public static int lcsit(int a[]) {
        int max = 0;

        for (int i = 0; i < a.length;i++) {
            int prev = i;
            int count = 0;

            for (int j = i; j<a.length;j++) {
                if ( a[j] >= a[prev]) {
                    count++;
                    prev = j;
                }
            }
            max = Math.max(count,max);
        }
        return max;
    }


    public static void main(String args[]) {

        int a[]={4,2,3,6,10,1,12};

        System.out.println(lcsit(a));
        System.out.println(lcssr(a,0,-1));
    }


}
