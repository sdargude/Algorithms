package com.xyz;
/* Problem:
    Given an array of integers from 1 to N. Find the missing number.

    Solution:
    Option1: Sort the array, and traverse one time to find mising number. O(nlogn) + n .

    Option2: Put it in hashset and find missing key by probing every element from 1 to n. O(n) + aux space of o(n).

    OPtion3: every element (2 to n) from arrays Xors with first element.  Whichever is missing name will be value o(N).
            solution.

 */

public class MissingElement {
}
