package Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class KnightTour {

    static ArrayList<Integer> minmoves;
    static int chess[][];
    static int possiblemoves = 8;
    static int possiblex[] = {-1, 1, 2, -2,  2, -2, -1, 1};
    static int possibley[] = {-2,-2,-1,  1,  1,  1,  2, 2};


    static boolean isValidMove(int rows, int cols, int startx, int starty, int move){
        int x = startx + possiblex[move];
        int y = starty + possibley[move];

        if (x<0 || y<0) return false;

        if (x <rows &&  y < cols) {
            if(chess[x][y] == 1) return false;
            return true;
        }
        return false;
    }


    static boolean  tour(int rows, int cols, int moves, int startx, int starty, int endx, int endy) {

        if (startx == endx && starty == endy) {
            minmoves.add(moves);
            return true;
        }

        for (int i=0; i< possiblemoves; i++) {
           int x = startx + possiblex[i];
           int y = starty + possibley[i];

           if (isValidMove(rows, cols, startx,starty,i) == false) continue;
           chess[x][y] = 1;
           tour (rows,cols, moves+1, x, y, endx, endy);
           chess[x][y]=-1;
        }

        return false;
    }

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {

        chess = new int[rows][cols];
        minmoves = new ArrayList<>();
        for(int i=0; i<rows; i++)
            for (int j=0; j<cols; j++)
                chess[i][j] = -1;


        chess[start_row][start_col] = 1;
        tour(rows,cols,0, start_row,start_col, end_row,end_col);

        if (minmoves.size() == 0) return -1;
        return Collections.min(minmoves);
    }

    public static void main(String [] args){


        int min = find_minimum_number_of_moves(2,50000,1,997,0,49997);
        System.out.println(min);
    }


}
