package com.xyz.mystrings;
/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



 Solution:

   Bruteforce:
        1. Find all substrings and check if it has all unique characters. N *N * N.


        2.  Starting with start index, insert every item in an hashset.
                    Incase the element exists in set, remove the element from the set.



              e.g. ABCBDE

              i=0, j=0, set=[]

              while(i<s.len && j<s.len)


            A [A] i=0, j=1   len 1
            B [A,B] i=0, j=2  len 2
            C [A,B,C] i=0, j=2 len 3
            B [A,B,C] :
                    Cannot ADD B
                            Remove A i=1
                            Loop back:
                                    Cannot Add B,
                                    Remove B i=2  j = 4 len=2 loopbacj
           B[C,B] i = 2, j=4, len=2;

           Max of len 3. hence answer is 3.





 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int solution(String s){
        int len = 0;

        int i =0, j =0;

        Set<Character> set = new HashSet<>();

        while (i<s.length() && j <s.length()) {

            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }else{
                set.add(s.charAt(j));
                j++;
            }

            len = Math.max(len, Math.abs(i-j));
        }

        for (char x : set)
            System.out.println(x);
        return len;
    }

    public static void main(String args[]) {
        String s= "ABCABCD";
        System.out.println(s+ " : " + solution(s));

    }
}
