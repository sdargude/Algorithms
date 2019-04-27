/*Problem:
    Given a integer array and integer K. Find all number of subsets which would have sum of elemnts == K.

    e.g.
    int ƒ(index i, sum K)
        if K == 0 return 1;
        if i == len(Array) return 0;
        return ƒ( i+1, k) + ƒ(i+1, k-array[i])


    one constraint optimzation we can do is,

    if (array[i] > k) ƒ(i+1,k) // skip.



 */

public class SumSubset {

    static int sumfunction(int array[], int i, int k) {
        if (k==0) return 1;
        if (i == array.length) return 0;
        return sumfunction(array,i+1, k) + sumfunction(array, i+1, k-array[i]);
    }


    public static void main(String []args){
        int array[] = {1,2,3,4,5};
        System.out.println(sumfunction(array,0,8)  );
    }

}
