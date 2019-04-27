package Pattern5;


/*
 Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.

 Input: s1 = "abdca"
        s2 = "cbda"
Output: 2
Explanation: The longest common substring is "bd".


Solution:

1. For every index of S2, find the longest substring.

        int longestsubstringfunction (int i) {

                j = 0;
                count =0;
                lastmast=0;
                while(i<S1.len) {
                    if (j == S2.len) { j=lastmatch; i++)};
                    if (s1[i] == s2[j]) {count++, i++, j++; lastmast=i}
                    else  { j++; count=0;}
                 }
            return count;

      Time complexity (S1.len * S2.len) * S1(len)  ie. N x N x M;




2.LCS(S1, i, S2, j,count){

        if (i >= S1.len() || j >= S2.len()) return count;

        if (S1[i] == S2[j])
            count = LCS(S1,i+1, S2, j+1, count+1)


        c1 = LCS(S1,i+1, S2, j, 0)
        c2 = LCS(S2,i, S2,j+1,0)

        return max(count,c1,c2);


    Time complexity of 2 ^ (N+M)  , Space O(N+M).




3.With DP

    if (S1[i] == S2[j])
        d[i][j] = 1 + d[i-1][j-1]
    else
        d[i][j] = 0;


   Time complexity of O(N * M) ,Space O(N * M)

 */

public class LongestSubstring {


    public static int lcsrecursive(String S1, int i, String S2, int j, int count) {

        if (i == S1.length() || j == S2.length())
            return count;


        if (S1.charAt(i) == S2.charAt(j))
            count = lcsrecursive(S1,i+1, S2, j+1, count+1);


        int c1 = lcsrecursive(S1,i+1, S2, j,0);
        int c2 = lcsrecursive(S1,i, S2,j+1, 0);

        return Math.max(count,Math.max(c1,c2));

    }



    public static int lcsdp (String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        int max = 0;

        for (int i = 1 ; i<=n; i++) {
            for (int j =1; j<=m; j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }


    public static void main(String args[]) {

        String S1 = "passport";
        String S2 = "ppsspt";



        long starttime = System.currentTimeMillis();
        System.out.println("Recurssive : " + lcsrecursive(S1,0,S2,0,0));
        long endtime = System.currentTimeMillis();
        System.out.println("Reccursive Took : "  + ( endtime - starttime));

        starttime = System.currentTimeMillis();
        System.out.println("DP : " + lcsdp(S1,S2));
        endtime = System.currentTimeMillis();
        System.out.println("DP Took : "  + ( endtime - starttime));

    }

}
