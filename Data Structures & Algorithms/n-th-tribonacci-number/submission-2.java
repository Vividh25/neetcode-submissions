class Solution {
    Integer[] dp;
    public int tribonacci(int n) {
        dp = new Integer[n + 1];
        return recur(n);
    }

    public int recur(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        } 

        if (dp[n] != null) return dp[n];

        return dp[n] = recur(n - 1) + recur(n - 2) + recur(n - 3);
    }
}