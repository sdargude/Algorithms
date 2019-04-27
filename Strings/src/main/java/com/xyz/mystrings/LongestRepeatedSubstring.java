package com.xyz.mystrings;

/* Problem Statement :

Given a string inputStr of length n, find the longest repeated substring in it.

- Repeated is occurring more than once. It doesn't matter how many times it occurs as far as it occurs more than once.
- If there are multiple such substrings of the same size, then return any one.
- If there are no repeated substrings, then return an empty string.


Input STR : aaaa
output: 3 (string aaa, repeats from 0, or 1).

Input: efabcgabcgh
output: abcg abcg is repeating, hince answer is 4.


Problem:

Brute force approach can be find all substrings and match it.

Optimized solution can be to create a suffix tri of the string. Everytime a node is visited again,
 increment the  counter.


        h

        g  h
        g2 a b c g h

        c   g h
        c2 g2 h2 a b c g h

        b  c  g  h
        b2 c2 g2 a b c g h

        a  b  c  g  h
        a2 b2 c2 g2 h2 a b c g h

        f a b c g a b c g h

        e f a b c g a b c g n



        Now only pick those branches which have incremented root values, in our case branch g, b, a,

        traverse branch till node which has lesser count than starting position.

        E.g. if we start from g, g is 2, next node is h or a, both have values 1 (default value). break.
             Hence repeated string is g.

             try b,  the string is bcg.

             try a,  abcgh.

             which is the longest repeating  substring..

 */


public class LongestRepeatedSubstring {
}
