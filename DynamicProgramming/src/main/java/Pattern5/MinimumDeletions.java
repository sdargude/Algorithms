package Pattern5;
/*
Given a number sequence, find the minimum number of elements that should be deleted to make the remaining sequence sorted.

Example 1:


Input: {4,2,3,6,10,1,12}
Output: 2
Explanation: We need to delete {4,1} to make the remaing sequence sorted {2,3,6,10,12}.
Input: {4,2,3,6,10,1,12}
Output: 2
Explanation: We need to delete {4,1} to make the remaing sequence sorted {2,3,6,10,12}.


Solution:

    THis is a longestSubsequence variation. Where one need to delete difference between lcs and array len.

    so minimum deletion is len - lcs.


 */
public class MinimumDeletions {

    public static void main(String []args) {

        int array[] = {4,2,3,6,10,1,12};

        System.out.println("Minimum deletion " + (array.length -  LongestIncreasingSequence.lcsit(array)));

    }
}
