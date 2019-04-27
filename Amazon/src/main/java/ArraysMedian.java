/*
Problem: There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [23, 24]

high = 4/2=2
low = 3/2=1

100,200, i =0       i=0
23 j=0              j=1


23          i=1
100,200     j=0

count=2

a[i]+b[j]



1,2 : 2

1/2 = 0
2/2 = 1


if len == odd
    high = n-1/2.
    low = n-1/2
    median = (high + low)/2.

else
    high = (n)/2.
    low = (n-1)/2.


count = 0;

i=0,

while(i<a.len && j<b.len ){

        if (count == high) break;
        if (a[i] > b[j]) i++;
        else j++;

        count++;
}




 */

public class ArraysMedian {
}
