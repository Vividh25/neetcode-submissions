class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp = new Integer[n + 1];
        return recur(n);
    }

    public int recur(int n) {
        if (n == 0) return 1;

        if (n < 0) return 0;

        if (dp[n] != null) return dp[n];

        int oneStep = recur(n - 1);
        int twoStep = recur(n - 2);

        dp[n] = oneStep + twoStep;
    
        return dp[n];
    }
}
