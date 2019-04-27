/*
* Problem:
* Find a subsets of an integer where the difference between sums is minimum
*
* Solution:
*   Total = ∑ array[i] where 0 <= i < array.length.
*
*   ƒ(i,sum):
*       if (i == leng(Array) return abs(Total - 2 *sum))
**       return MIN(ƒ(i+1, sum), ƒ(i+1, sum-array[i]). This is pick and skip approach.
*
*
* Above function computes all the possible subsets (
*
*
* */

public class SubsetMinimumdiff {
}
