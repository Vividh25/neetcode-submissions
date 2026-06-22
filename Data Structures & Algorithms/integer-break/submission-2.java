class Solution {
    Integer[][] dp;
    public int integerBreak(int n) {
        dp = new Integer[n + 1][n + 1];
        return recur(n, 1, false);
    }

    public int recur(int n, int i, boolean split) {
        if (n <= 0 || i <= 0) return 1;
        if (i >= n) return split ? n : 0;

        if (dp[n][i] != null) return dp[n][i];

        int subtract = i * recur(n - i, i, true);
        int dontSub = recur(n, i + 1, split);

        return dp[n][i] = Math.max(subtract, dontSub);
    } 
}