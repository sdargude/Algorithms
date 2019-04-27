public class NumIslands {

    public static void dfs (int grid[][], int r, int c){

        if ( r >= grid.length || c >= grid[0].length || c <0 || r<0)
            return;

        if (grid[r][c] == 0) return;

        grid[r][c]=0;

        dfs(grid,r+1,c);
        dfs(grid, r,c+1);
    }


    public static void main(String args[]) {

        int grid[][] = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,0,0,0,0},
                {0,0,1,0,1},
            };


        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        System.out.println("Count = " + count );
    }
}
