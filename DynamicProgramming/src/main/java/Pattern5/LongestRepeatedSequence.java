package Pattern5;


/*
Given a sequence, find the length of its longest repeating subsequence (LRS).
A repeating subsequence will be the one that appears at least twice in the original
sequence and is not overlapping (i.e. none of the corresponding characters in the repeating
subsequences have the same index).

Example 1:

input : tomorrow
output: 2

or repeates.

Solution:

   1, Brute force method of solving it would be to find all the subsets of the string, and see how many  same subsets
    are formed. 2 ^ n subets. One may need a hashmap <String, int> for storing and comparing.

   2. Other recursive solution can be similar to similar to LCS of two strings with following exceptions

    a.  Both the strings are same.
    b.  For the condition, where s1[i] == s2[j], i & j should not be same.

    Again 2^2n solution, but would have lesser space complexity.


    3. DP solution would
        if (i!= j && s1[i] == s[j])
            d[i][j] = d[i-1][j-1]  + 1;
        else
            d[i][j] = max(d[i-1][j], d[j][j-1]).

        O(NxN) solution
 */

public class LongestRepeatedSequence {


    public static int lrsrec(String s, int i, int j ){
        if (j == s.length() ||  i == s.length())
            return 0;

        if (i != j && s.charAt(i) == s.charAt(j))
            return 1 + lrsrec(s,i+1,j+1);

        int c1 = lrsrec(s,i+1,j);
        int c2 = lrsrec(s,i,j+1);

        return Math.max(c1,c2);
    }


    public static int lrssecdp(String s) {

        int n = s.length() + 1;
        int d[][] = new int [n][n];

        int max = 0;
        for (int i = 1; i<n; i++) {
            for (int j =1; j<n; j++) {
                if (i != j && s.charAt(i-1) == s.charAt(j-1)) {
                    d[i][j] = 1 + d[i-1][j-1];
                }else{
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }

                max = Math.max(max,d[i][j]);
            }
        }

        return max;

    }


    public static void main(String args[]) {

        String s = "Tomorrow";

        System.out.println("Rec : " + lrsrec(s,0,0));
        System.out.println("DP  : " + lrssecdp(s));

    }

}
