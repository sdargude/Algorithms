package Pattern4;

/*
Given a string, find the length of its Longest Palindromic Substring (LPS). In a palindromic string, elements read the same backward and forward.

Example 1:


Input: "abdbca"
Output: 3
Explanation: LPS is "bdb".



Solution:

    1. Brute force, find all substring and check if the substring is palindrome and get max.
        N * N -> Substring.  N for each palindrome.  Total time complexity O ( N * N * N )

    2. Iterative solution:

            Property of Palindrom

                  1.Len is odd, there is single element in middle (as partition),
                    left and right of partiton are mirror images.

                  2.Len is even, then the partion exits between two element,
                    left an right of partition are same.


                  3. Lets say if we have a  blackbox function which would find left and right of partition
                    and check if they are same. If they are same return lenght of the half.

                    begin an end are start and end of the partition.

                    for odd len string, begin & end will be same.
                    for even len string begin & end will be one element apart.



                  int blackbox(String s1, int begin, int end)
                       count = 0;
                       int diff = end - begin + 1;

                      while (begin >= 0 && end < s1.len() && s[begin] == s[end] ) {

                            begin--;
                            end++;
                            count++;
                      }

                        return count + diff; This is would be length of string which is palindrome, including
                                              partition.,


*/


public class LongestPalindromSubstring {


    public static boolean isPalindrome(char c[], int start, int end) {
        for (int i = start; i <= end ; i++) {
            if (c[i] != c[start+end-i])
                return false;
        }
        return true;
    }


    public static int getSubstrings(char c[]) {
        int max = 0;

        for (int i = 0; i<c.length; i++ ){
            for ( int j = i; j < c.length;j++) {
                if (isPalindrome(c,i,j)){
                    max = Math.max(max, (j-i+1));
                }
            }
        }

        return max;
    }

    public static  String blacbox(String s, int begin, int end) {

        while (begin >=0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

      //  System.out.println("Begin "  + begin + " End " + end);
        return s.substring(begin+1,end);

    }


    public static int lcps(String s) {
        int max = 0;

        for (int i = 0; i< s.length(); i++) {
            String max1 = blacbox(s,i,i);
            System.out.println(i+ " : " + max1 + " " + max1.length());
            String max2 = blacbox(s, i, i+1);
            System.out.println(i+ " : " + max2 + " " +  max2.length());
          //  System.out.println("Max i=" + i+ " " +max1 + "  " + max2);
        }
        return max;
    }

    public static void main(String args[]) {

        String s = "ABAC";
        long start = System.currentTimeMillis();
        System.out.println("Substring is : " + getSubstrings(s.toCharArray()));
        long end = System.currentTimeMillis();
        System.out.println("Took : " + (end - start));

        start = System.currentTimeMillis();
        System.out.println("LCS is : " + lcps(s));
        end = System.currentTimeMillis();
        System.out.println("Took : " + (end-start));
    }

}
