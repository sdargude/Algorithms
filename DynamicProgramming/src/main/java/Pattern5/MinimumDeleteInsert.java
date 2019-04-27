package Pattern5;

/*
Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters.
Write a function to calculate the count of the minimum number of deletion and insertion operations.

Input: s1 = "abdca"
       s2 = "cbda"
Output: 2 deletions and 1 insertion.
Explanation: We need to delete {'a', 'c'} and insert {'c'} to s1 to transform it into s2.




Solution:

This is extention LCS problem. Find minimum of S1 and S2.  From above example, lcs is bda i.e. 3.  Now delete remaining
2 characters from s1 ie. (len(s1)-lcs), insert character in s2 (len(s2)-lcs).


 */

public class MinimumDeleteInsert {

    public static void main(String[] args) {

        String s1 = "abdca";
        String s2 = "cbda";

        int lcs = LongestSubsquence.lcsdp(s1,s2);

        int min = (s1.length() - lcs )+ (s2.length() - lcs);

        System.out.println("Minimum delete, inserts " + min);

    }

}
