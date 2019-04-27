package Pattern4;

/*
    Given  a String, find a longest subsquence which has longest palindrome.

Input: "abdbca"
Output: 5
Explanation: LPS is "abdba".


Solution:
    Brute force mechanism:

     1. Compute all subsequence (subset) and check if its palindrome and find the max length string.
     2. Recurrsive approach would be

            start with 2 pointers startindex=0, endindex=s.len - 1.

           int lps (startindex, endindex){

           if (starindex > endindex) return 0;

           if (startindex == endindex) return 1;

           if S[startindex] == S[endindex]
                return 2 + lps (starindex+1, endindex-1)


          c1=lps(startindex+1, endindex)
          c2=lps(startindex, endindex-1)

          return max(c1,c2).


        Time complexity O(2 ^ N), Space complexity(N)


    3. DP

            if (S[startindex] == S[endindex])
                D[startindex][endindex] = 2 +D[startindex-1][endindex-1]

            else
                D[startindex][endindex] = max(D[startindex-1][endindex], D[startindex][endindex-]).



            Initialization: Every sequence with one element is a palindrome of length 1


                    C   D   D   P   D

                C   1   0   0   0   0

                D   0   1   0   0   0

                D   0   0   1   0   0

                P   0   0   0   1   0

                D   0   0   0   0   1



                O(N ^ 2).


 */


public class LongestPalindromSubsequence {

    public static boolean isPalindrome (char current[], int end) {

        if (end == 0 ) return false;

        for (int i = 0; i<end;i++) {
            if (current[i] !=  current[end-1-i])
                return false;
        }
        return true;
    }


    public static int getSubsets(String s, char current[], int c, int index) {

        if (index == s.length())  {
            if (isPalindrome(current,c)) {
                return c;
            }
            return 0;
        }

        int c1=  getSubsets(s,current,c,index+1);
        current[c] = s.charAt(index);
        int c2 = getSubsets(s,current,c+1,index+1);


        return Math.max(c1,c2);
    }


    public static int lps(String s, int startindex, int endindex) {

        if (startindex > endindex) return 0;

        if (startindex == endindex) return 1;


        if (s.charAt(startindex) == s.charAt(endindex)) {
            return  2 + lps(s,startindex+1, endindex-1);
        }

        int c1 = lps (s, startindex +1, endindex);
        int c2 = lps (s,startindex, endindex-1);

        return Math.max(c1,c2);


    }

    public static void main (String args[]) {

        String s1 = "abdbcaasdlee1dfj0129uadakj";
        char current[] = new char[s1.length()];

        long start = System.currentTimeMillis();
        System.out.print("Subset " + getSubsets(s1,current,0,0));
        long end = System.currentTimeMillis();
        System.out.println(" " + (end-start));

        start = System.currentTimeMillis();
        System.out.print("LPS " + lps(s1,0,s1.length()-1));
        end = System.currentTimeMillis();
        System.out.println(" " + (end-start));


    }
}
