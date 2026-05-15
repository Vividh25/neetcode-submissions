class Solution {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new Integer[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        return recur(obstacleGrid, 0, 0);
    }

    public int recur(int[][] grid, int i, int j) {

        if (i >= grid.length || j >= grid[0].length) return 0;
        
        if (grid[i][j] == 1) return 0;

        if (i == grid.length - 1 && j == grid[0].length - 1) return 1;

        if (dp[i][j] != null) return dp[i][j];

        int moveRight = recur(grid, i, j + 1);
        int moveDown = recur(grid, i + 1, j);

        return dp[i][j] = moveRight + moveDown;
    }
}