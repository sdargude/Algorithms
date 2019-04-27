/* Problem:
 Given a grid of size N X M , Find maximum number of cells to to travel , starting from 0X0 to N -1 X M-1  cell. Assume
 each cell value has one. One can move either to left or down from a cell.

 Solution:
    This is a classic divide and concur problem. From a given cell, there are two sub-problem. First without current row and
    other sub problem is one without current problem.


        traverse (r+1, c , sum + matrix[r,c]); Down
        traverse (r, c+1, sum + matrix[r,c]); Left.


     Base condition : when r,c is same as n-1, m-1.

     Initial condition: traverse (0,0,0);

     Time complexity is  2 ^ n + m:

             Time complexity of this algorithm is B ^ H. Where B is branching factor and H is max height of recurssive
             tree.On every cell we have branching factor of 2 (We can go left or down). Height of recursive tree is max
             number of moves which are N + M.  Hence Time complexity of this algorithm is 2 ^ M + N


     Space complexity is O(H) which is O( N + M ). Recursive calls.
 */



import java.util.Random;

public class MaxPathCount {

    static int maxsum = 0;
    static int counter = 0;
    static void traverse(int matrix[][], int row, int col, int sum) {

        if (row == matrix.length || col == matrix[0].length) {
            return;
        }

        if ( row == matrix.length - 1 && col == matrix[0].length -1 ){
            if (maxsum < sum + matrix[row][col])
                    maxsum = sum + matrix[row][col];
            counter++;
            return;
        }

        traverse(matrix, row+1, col,  sum + matrix[row][col]);
        traverse(matrix, row, col+1, sum + matrix[row][col]);
    }


    public static void main (String s[]) {

        int row = 2;
        int col = 2;
        int matrix[][] = new int [row][col];
        Random r = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = r.nextInt(10);
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("--------");
        traverse(matrix, 0,0,0);
        System.out.println("MaxPath = " + maxsum + " Counter " + counter);
    }
}
