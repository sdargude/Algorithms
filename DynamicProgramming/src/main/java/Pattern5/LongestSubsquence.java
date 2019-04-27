package Pattern5;


/*

Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence which is common in both the strings.

Input: s1 = "passport"
       s2 = "ppsspt"
Output: 5
Explanation: The longest substring is "psspt".


Solution:
    1. Iterative solution (Blackbox solution) similar to Longestsubstring, it would N * N * M

    2. Recurssive solution:

        int lcs(S1,i, S2,j){

            if (i >= S1.len || j >= S2.len) return 0;

            if (S1[i] == S2[j] return 1 + lcs(S1,i+1, S2,j+1)

           c1= lcs(S1,i+1, S2, j+1)
           c2= lcs(S2,i,S2, j+1)

           return max(c1,c2).
        }

        TC = O(2^ (N*M)) ,



    3. if (S1[i] == S2[j])
            d[i][j] = 1 + d[i-1][j-1]
       else
            d[i][j] = max(d[i-1][j], d[i][j-1])/



 */

public class LongestSubsquence {


    public static int recurrsivelcs(String S1, int i, String S2, int j ) {

        if (i >= S1.length() || j >= S2.length())
            return 0;

        if (S1.charAt(i) == S2.charAt(j))
            return 1 + recurrsivelcs(S1,i+1, S2,j+1);

        return Math.max(recurrsivelcs(S1,i+1, S2,j), recurrsivelcs(S1,i,S2,j+1));

    }


    public static int lcsdp (String S1, String S2) {

        int n = S1.length();
        int m = S2.length();

        int d[][] = new int[n+1][m+1];

        int max = 0;
        for (int i = 1; i < n + 1; i++ ){
            for (int j = 1; j< m + 1; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)){
                    d[i][j] = 1 + d[i-1][j-1];
                }else {
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }

                max = Math.max(d[i][j], max);
            }
        }

        for (int i = 0; i<n+1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

        return d[n][m];
    }


    public static void main(String args[]) {

        String S1 = "passport";
        String S2 = "ppsspt";

        long starttime = System.currentTimeMillis();
        System.out.println("Recurssive : " + recurrsivelcs(S1,0,S2,0));
        long endtime = System.currentTimeMillis();
        System.out.println("Reccursive Took : "  + ( endtime - starttime));

        starttime = System.currentTimeMillis();
        System.out.println("DP : " + lcsdp(S1,S2));
        endtime = System.currentTimeMillis();
        System.out.println("DP Took : "  + ( endtime - starttime));

    }

}
