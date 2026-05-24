class Solution {
    int ROWS;
    int COLS;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        dp = new Integer[ROWS][COLS];

        int ans = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (i >= ROWS || j >= COLS || i < 0 || j < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int best = 1;

        for (int[] dir : directions) {
            int nr = i + dir[0], nc = j + dir[1];
            if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && matrix[nr][nc] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(matrix, nr, nc));
            }
        }

        return dp[i][j] = best;
        
    }
}
