package Pattern5;

/*
Given sequences ‘s1’ and ‘s2’, write a method to find the length of the shortest sequence which has ‘s1’ and ‘s2’ as subsequences.

Example 2:


Input: s1: "abcf" s2:"bdcf"
Output: 4
Explanation: The shortest common super-sequence (SCS) is "abdcf".


Solution:

    i is index of  S1.
    j is index of S2.


    if value of i and j is same then we have have one super sequence.

    if not, we have choice to move i or j. But for each movement of i or j, we have additional character in
    super sequence.

    we need to find the minimum between last two conditions.


    Base condition: if i reaches end of S1 or j reaches end of s2.  We need to return remaining string.
    ie. Si - i or Sj - j.


    The branching is 2 , hence the time complexity is O(2 ^ (N+M)).



  DP solution:

        d[i][j] = 1 + d[i-1]d[j-1]
            else
        d[i][j] = 1 + min (d[i-1][j], d[i][j-1])



        intialize
              a b c f
             0 1 2 3 4

        b 0  0 1 2 3 4
        d 1  1
        c 2  2
        f 3  3


        If S2 is empty, super sequence is len of s1 and vice versa,


        Time complexity O (N*M), space complexity O(N * M).

 */


public class ShortestCommonSuperSequence {

    public static int scsrec (String S1, int i, String S2, int j) {

        if (i == S1.length()) return S2.length() -j;
        if (j == S2.length()) return S1.length() - i;

        if (S1.charAt(i) == S2.charAt(j))
            return 1 + scsrec(S1,i+1, S2,j+1);


        int c1 = scsrec(S1, i+1, S2, j);
        int c2 = scsrec(S1, i, S2,j+1);

        return 1 + Math.min(c1,c2);
    }



    public static int scsdp (String S1, String S2) {

        int n = S1.length() + 1;
        int m = S2.length() + 1;

        int d[][] = new int [n][m];


        for (int i = 0;i<n;i++) {
            d[i][0] = i;
        }

        for (int j = 0; j<m;j++) {
            d[0][j]=j;
        }


        int min = 0;
        int i=0 , j=0 ;
        for ( i = 1; i<n; i++) {
            for (j = 1; j<m ; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)) {
                    d[i][j] = 1 + d[i-1][j-1];
                } else {
                    d[i][j] = Math.min(d[i-1][j], d[i][j-1]) +1;
                }

            }
        }
        return d[i-1][j-1];
    }


    public static void main(String args[]) {
        String S1 = "abcfabakakasdad";
        String S2 = "bdcfabadadas";

        long start = System.currentTimeMillis();
        int min = scsrec(S1,0,S2,0);
        long end = System.currentTimeMillis();

        System.out.println("Rec " + min + " Took " + (end-start) + " msec!");

        start = System.currentTimeMillis();
        min = scsdp(S1, S2);
        end = System.currentTimeMillis();

        System.out.println("DP " + min + " Took " + (end-start) + " msec!");
    }
}
