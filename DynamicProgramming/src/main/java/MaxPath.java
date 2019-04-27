/* Given a matrix of positive integers, find a path from CellA to CellX such that sum of path is maximum.


05  10 20 30
35  04 25 15
92  80 61 72
12  16 70 02
06  18 41 03


MaxPath from [0,0] to [4,4]



Branching: can go right or bottom.

At every cell we have to choices c+1 (right) or r+1 (down), where c+1 and r+1 are in grid.

finalvalue = current cell value + Max(goleft, goright);


 */

public class MaxPath {

    /* O(2 ^ N+M)
       Recurrsive solution.
     */
    static int maxpath(int matrix[][], int r, int c) {

        if (r >= matrix[0].length || c >= matrix[0].length) return 0;
        if (r==3 || c==3) return matrix[3][3];

        int right = matrix[r][c]+ maxpath(matrix,r,c+1);
        int down = matrix[r][c] + maxpath(matrix,r+1,c);

        return Math.max(right,down);
    }



    public static void main(String args[]) {

        int matrix[][]={
                        {5,10,20,30},
                        {35,04,25,15},
                        {92,80,61,72},
                        {12,16,70,02},
                        {06,18,41,03}
                        };

        System.out.println(maxpath(matrix, 0,0));

    }
}
