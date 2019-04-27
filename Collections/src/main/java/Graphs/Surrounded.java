package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Surrounded {

    public void solve(char[][] board) {

         if (board.length <= 0) return ;

        Queue <Integer> queue = new LinkedList<Integer>();
        int [] visited = new int [board.length * board[0].length];
        Arrays.fill(visited,0);

        for (int row = 0; row<board.length; row++) {
            if (row == 0 || row == board.length -1 ) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 'O') {
                        ((LinkedList<Integer>) queue).addLast(row * board[0].length + col);
                       // System.out.println("Row :" + row + " Col  :" + col + " " + (row*board[0].length + col));
                    }
                }
            } else {
                if (board[row][0] == 'O') {
                    ((LinkedList<Integer>) queue).addLast(row * board[0].length + 0);
                   // System.out.println("Row :" + row + " Col  :" + 0+ " " + (row*board[0].length + 0));
                }
                    if (board[row][board[0].length -1] == 'O') {
                        ((LinkedList<Integer>) queue).addLast(row * board[0].length + board[0].length - 1);
                      //  System.out.println("Row :" + row + " Col  :" + (board[0].length - 1)+ " " + (row*board[0].length + board[0].length -1));
                    }
            }

        }


        while(!queue.isEmpty()) {
            int pos =  ((LinkedList<Integer>) queue).pollFirst();
            int row = pos / board[0].length;
            int col = pos % board[0].length;
          //  System.out.println(pos + " Row " + row + " Col " + col);
            if (visited[pos] == 1) continue;
            if (col + 1 <= board[0].length - 1) {
                if (board[row][col + 1] == 'O')
                    ((LinkedList<Integer>) queue).addLast(row * board[0].length + col + 1);
            }

            if (col - 1 >= 0 ) {
                if (board[row][col - 1] == 'O')
                    ((LinkedList<Integer>) queue).addLast(row * board[0].length + col - 1);
            }

            if (row + 1 <= board.length - 1) {
                if (board[row  + 1][col] == 'O')
                    ((LinkedList<Integer>) queue).addLast((row + 1) * board[0].length + col);
            }

            if (row -1 >= 0) {
                if (board[row -1][col] == 'O')
                    ((LinkedList<Integer>) queue).addLast((row - 1) * board[0].length + col);
            }

            visited[pos] = 1;
         //   System.out.println(pos+ " : " + row  + " " + col);
        }
//

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length ; col++){
                int pos = row * board[0].length + col;
                if (board[row][col] == 'O' && visited[pos] != 1)
                    board[row][col] = 'X';
            }
        }

       // display(board);

    }

    public void display(char [][] a) {
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[i].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String args[]) {
        char a[][] = {
                        {'X','O','X','X'},
                        {'O','X','O','X'},
                        {'X','O','X','O'},
                        {'O','X','O','X'},
                        {'X','O','X','O'},
                        {'O','X','O','X'}
                      };
        char b[][] = {};

        System.out.println(a);
        Surrounded s = new Surrounded();
        s.display(a);
        s.solve(a);
        System.out.println("--------After----------");
        s.display(a);

        s.solve(b);
    }
}
