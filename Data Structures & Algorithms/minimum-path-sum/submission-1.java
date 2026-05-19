class Solution {
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new Integer[grid.length + 1][grid[0].length + 1];
        return recur(grid, 0, 0);
    }

    public int recur(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;

        if (dp[i][j] != null) return dp[i][j];

        int down = recur(grid, i + 1, j);
        int right = recur(grid, i, j + 1);

        int minSum = Math.min(down, right);

        return dp[i][j] = grid[i][j] + minSum;
    }
}