class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        return recur(m, n, 0, 0);
    }

    public int recur(int m, int n, int i, int j) {
        if (i >= m || j >= n) return 0;

        if (i == m - 1 && j == n - 1) return 1;

        if (dp[i][j] != 0) return dp[i][j]; 

        int goRight = recur(m,  n, i+1, j);
        int goDown = recur(m, n, i, j+1);
        dp[i][j] = goRight + goDown;
        return dp[i][j];
    }
}
