class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length + 1];
        return Math.min(recur(cost, 0), recur(cost, 1));
    }

    public int recur(int[] cost, int i) {
        if (i >= cost.length) return 0;

        if (dp[i] != null) return dp[i];

        int first = cost[i] + recur(cost, i + 1);
        int second = cost[i] + recur(cost, i + 2);

        dp[i] = Math.min(first, second);

        return dp[i];
    }

}
