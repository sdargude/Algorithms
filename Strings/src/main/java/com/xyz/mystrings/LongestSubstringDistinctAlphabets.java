package com.xyz.mystrings;


/* Problem statement :
Given a string s of length n, find the length of the longest substring ss that contains exactly two distinct characters.


e.g  eceba      : Output is 3. i.e ece.
e.g. abcdef     : Output is 2: ab , bc, cd, de, ef (any of it).
e.g. ababababa  : Output is 9.
e.g. e          : Output is 0.
e.g. baabcbab   : Output is 4.



Solution:

Idea is to use a rolling hash to move a sliding window of minimum size two. Keep increasing the window till there are only
two distinct characters in window. If the next character is not distinct, record the window size and remove left most
element of window.




 */
public class LongestSubstringDistinctAlphabets {
}
