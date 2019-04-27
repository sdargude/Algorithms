
/* Given a knapsack, which can hold maximum wieght capacity of W, insert unique items in the knapsack to maximize profit.

 */

import com.sun.rowset.internal.Row;

public class KnapSack {

    /* Recursive Solution  */
    static int solveknapsack(int W[], int P[], int currentIndex,  int capacity){

        if (capacity <= 0 || currentIndex < 0 || currentIndex >= P.length)
            return 0;

        int profitwith = 0;

        if ( capacity >= W[currentIndex]) /* If the current item is more than capacity, ignore */
            profitwith = P[currentIndex] + solveknapsack(W,P,currentIndex+1,
                    capacity-W[currentIndex]);

        //Exclude
        int profitwithout = solveknapsack(W,P,currentIndex+1,capacity);
        return Math.max(profitwith,profitwithout);
    }


    /*DP Solution */


    static int solveknapsackdp(int W[], int P[],int capacity) {


        int Rows = W.length;
        int Cols = capacity + 1;

        int dp[][]=new int[Rows][Cols];

        //This is unecessary step, as array is already initialized to zero, as its of primtive type.
        //Good to have as it gives little clarity.

        for (int i=0; i<Rows;i++)
            dp[i][0]=0;


        for (int i=1;i<Cols;i++) {
            if (W[0] <= i)
                dp[0][i]=P[0];
        }

        int exclude= 0;
        int include = 0;

        for (int row = 1; row< Rows; row++) {

            for (int col=1; col<Cols;col++) {

                exclude = dp[row-1][col];

                include = 0;
                if (col >= W[row])
                    include = dp[row-1][col-W[row]] + P[row];

                dp[row][col] = Math.max(include,exclude);
            }

        }

//        for (int i = 0; i< Rows ; i++) {
//            for (int j= 0; j<Cols ; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

       // System.out.println("Answer" + dp[Rows-1][Cols-1]);
        return dp[Rows-1][Cols-1];
    }


    public static void main(String args[]) {
        int[] P = {2, 6, 10, 16,10,12, 31, 12, 123, 31, 12 };
        int[] W = {1, 2, 3,  5, 6, 123,13,  1, 12,  12, 31 };

        long start = System.currentTimeMillis();
        System.out.println("Recursive Solution :" + solveknapsack(W,P,0,72));
        long end = System.currentTimeMillis();
        System.out.println("Recurrsive solution took: " + (end - start) + "ms.");

        start = System.currentTimeMillis();
        System.out.println("DP Solution        :"  +solveknapsackdp(W,P,72));
        end = System.currentTimeMillis();
        System.out.println("DP solution took : " + (end-start) + "ms.");

    }

}
