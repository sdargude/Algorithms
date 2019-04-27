/* Given an array find if the sum of two numbers is target

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

A[] = {1,2,3,4,5} target = 7.
4,3
5,2

BruteForce:  N X N solution.

O(N) solution with extra space. can be put the number in hash and check if exists.

 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static void twoSum(int array[], int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i<array.length; i++) {
            int comp  = target - array[i];
            if ( map.containsKey(comp)) {
                System.out.println(array[i] + " " + comp);
            }
            map.put(array[i],array[i]);
        }
    }

    public static void main(String args[]) {
        int array[] = {1,2,3,4,5};
        twoSum(array,7);
    }
}
