/* Problem: Given a array of integers find a K such numbers whose sum is equal to 0.

e.g { -2,-3,2,5,1,-1,0)
    e.g {-3,2,1}
         {-1,1,0}
         {-2,2,0}


Solution:  This is a an variance of a subset problem.  Base case is current array lenght == K, and
if sum of elements in current array is 0, then print the set.
 */


public class _3Sum {

    static void subset (int []current, int curptr, int a[], int start, int sum, int k) {

        if (curptr == k || start == a.length) {
            if (sum == 0 && k == curptr) {
                for (int i = 0; i < k; i++)
                    System.out.print(current[i] + " ");
                System.out.println();
            }
            return;
        }

        subset(current, curptr, a,start+1, sum, k);
        current[curptr] = a[start];
        subset(current,curptr+1, a,start+1, a[start] + sum, k);

    }

    public static void main(String s[]) {
        int a [] = {-2,-3,2,5,1,-1,0};
        int current[] = new int[a.length];
        subset(current,0,a,0,0,3);
    }

}
