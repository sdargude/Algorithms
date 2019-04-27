package com.xyz;

/*
Problem:
Maximum Sum subarray problem: Given a an array of integers, find a  max sum sub array.
e.g. [1,-1,2,3,-4,5,1,-6]


Solution:

Since we are asked about subarray the poistion of element does matter,  hence sorting solution will not give us answer.

1. Brute force way would be find all the subarrays N X N loop, and find subarray. With complexity of O(N).
2. Kadanes algorithm

   1. Set maxarray to first element of array.
   2. Traverse array from next element(in this case it is 2nd).
        For every new element we have choices
            If the new element is greater than maxarray + element (current element) then
                    maxarray = current element;
            else
                    maxarray + element < 0, then maxarray = 0;
             else
                    maxarray = new element.




    Complexity is O(N).


e.g. -14,20,-6,3,4,-10

max subarray, is 20,-6,3,4 : 21

[0,20,14,17,21,11]


 */

public class Kadanes {
}
