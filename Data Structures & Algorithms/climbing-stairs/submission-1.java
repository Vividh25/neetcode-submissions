class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return backtrack(n);
    }

    public int backtrack(int n) {
        if (n == 0) return 1;
        if (n < 1) return 0;

        if (dp[n] != -1) return dp[n];

        dp[n] = backtrack(n-1) + backtrack(n-2);
        return dp[n];
    }
}
