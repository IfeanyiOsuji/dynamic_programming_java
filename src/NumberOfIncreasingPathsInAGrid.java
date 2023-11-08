package src;

import java.util.Arrays;

public class NumberOfIncreasingPathsInAGrid {
     // the four directions of the grid. if it is moving downward, the row icreases by 1 and column remains the same
    // if it is moving upward, the row number decreases and the column remains the same;
    // if it is moving forward, the column number increases and row  and the row remains the same, but the column number decreases if moving backward;
        int [][]direction = {{1, 0},{-1, 0}, {0, -1}, {0, 1}}; 
        int mod = 1000000007;
        int dj [] = {-1, 1, 0, 0};
    public int countParts(int [][] grid){
       int n = grid.length;
        int m = grid[0].length;
        int [][]dp = new int[n][m];

        for(int [] x: dp){
            Arrays.fill(x, -1);
        }

        int ans = 0;
        // iterating through each cell in the grid;
        for(int i=0; i<n; i++){
            for(int j=0; j< m; j++){
                ans = (ans + dfs(i, j, grid, dp))
            }

        }

    }
    private int dfs(int i, int j, int[][] grid, int[][] dp) {
            if(dp[i][j] != -1){
                return dp[i][j];
            }

            int count = 1;
            // moving through each direction
            for(int[] dir: direction){
                int x = i+dir[0], y= dir[1];
                //if the movement does not exceed the boundries of the grid and the next element is not less than the current element
                if(x>=0 && y>=0 && x < grid.length && y< grid[0].length && dp[x][y] > dp[i][j] ){
                count += (dfs(x, y, grid, dp)) % mod;
                }
            }
            return dp[i][j] = count % mod;
    }

    public static void main(String[] args) {
        
    }
    
}
