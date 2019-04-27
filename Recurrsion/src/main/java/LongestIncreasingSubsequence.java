
/*Problem: Given an array of integers, find a longest increasing subsequence of any array.

Solution:
        We have a black box function, which would give an answer for a longest sub sequence of an array, starting
        from an an index. Now rest is simple, we iterate through index from o to len of array, call the black box
        function which would give us the result.  At the end choose maximum amongst all result. This is not an recursive,
        approach, but this was the first intution which came to me.
 */

/* Complexity of this solution is N * N */

public class LongestIncreasingSubsequence {

    static int getcount(int array[],int index) {
        int count = 1;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] > array[i-1]) count++;
        }
        return count;
    }

    static int lcs (int array[]) {

        int max = 1;
        for (int i = 0; i<array.length; i++) {
                int res = getcount(array,i);
                if (max < res) max = res;
        }

        return max;
    }

    public static void main(String []s) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60,80 };
        System.out.println("LCS " + lcs(arr));
    }

}
