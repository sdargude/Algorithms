package Pattern5;

/*

Given a string and a pattern, write a method to count the number of times the pattern appears in
the string as a subsequence.

Example 1: Input: string: “baxmx”, patten: "ax"
Output: 2
Explanation: {baxmx, baxmx}.


Solution:
    1. Brute solution to find all subsequences and match the pattern.
    2. This is a typical skip and pick pattern, where

           (pick) if p[i] == s[j] then i+1, j+1.
            (skip)  j+1, p.

            return sum of both .

            base condition:
                if i == pat.len return 1.
                if j == str.len return 0;



    3. dp solution
            if p[i] == s[j]
                d[i][j] = d[i-1][j-1]
            d[i][j] += d[i][j-1]
 */

public class LongestSubsequencePattern {

    public static int patternmatch(String s, int i, String pat, int j) {

        if (j == pat.length()) return 1; // Matched successfully.
        if (i == s.length()) return 0;

        int c = 0;

        if (s.charAt(i) == pat.charAt(j))
            c = patternmatch(s,i+1,pat,j+1);


        int c2 = patternmatch(s,i+1,pat,j); //skip the string , this is hopping.

        return c + c2;
    }



    public static int patternmatchdp (String s, String pat) {

        int n = s.length() + 1;
        int p = pat.length() + 1;

        int d[][] = new int [n][p];

        for (int i = 0; i <n; i++)
            d[i][0] = 1;

        for (int i = 1;i<n;i++) {
            for (int j = 1; j<p; j++) {

                if (s.charAt(i-1) == pat.charAt(j-1))
                    d[i][j] = d[i-1][j-1];

                d[i][j]+=d[i-1][j];

            }
        }

        return d[n-1][p-1];
    }


    public static void main(String [] args) {

        String s1 = "baxmx";
        String s2 = "ax";

        System.out.println("Rec "  + patternmatch(s1,0,s2,0));
        System.out.println("DP  "  + patternmatchdp(s1,s2));


    }


}
