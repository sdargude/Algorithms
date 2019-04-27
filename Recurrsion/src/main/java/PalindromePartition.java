/*
Problem:
Given a String, Partition the string in such a way that all the partitions are palindrome.

E.g. S="aab",
    Palindrome partitions are
    a|a|b
    aa|b

    s="banab"

    b|a|n|a|b
    b|ana|b
    |banab|

Solution:
Brute force approach:

    Start with a poistion start=0,
            for (end=start to len(S))
                check if (substring of S.substr(start,end) == palindrome) {
                        Insert substr in output.
                        Recurrve set start=end,

                }


    Extension to the problem:  Find the minimum number of partitions.

 */

import java.util.ArrayList;

public class PalindromePartition {

    static ArrayList<String> output = new ArrayList<>();

    static boolean isPalindrome(String str) {

        char a[]  = str.toCharArray();
        int len = a.length-1;

        for (int i=0; i < a.length; i++) {
            if (a[i] != a[len-i]) {
                return false;
            }
        }
        return true;
    }

    enum direction {UP:1};


    static int decompose (String s, int start) {

        int min = Integer.MAX_VALUE;
        if (start >= s.length()) {
            System.out.print("Answer: ");
            for (String o:output) {
                System.out.print (o + " ");
            }
            System.out.println();
            return output.size();
        }



        for (int i = start; i<s.length();i++) {
            if (isPalindrome(s.substring(start,i+1))) {
                output.add(s.substring(start,i+1));
                int val = decompose(s,i+1);
                if (val < min) min = val;
                output.remove(output.size()-1);
            }
        }

        return min;
    }


    public static void main(String [] args) {
        String str= "abracadabra";
        Integer w = 121;
        w.toString();
        System.out.println(decompose(str,0));
    }
}
