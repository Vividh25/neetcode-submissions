class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length];
        int minCost1 = backtrack(cost, 0);
        int minCost2 = backtrack(cost, 1);
        return Math.min(minCost1, minCost2);
    }

    public int backtrack(int[] cost, int i) {
        if (i >= cost.length) return 0;

        if (dp[i] != null) return dp[i];
        dp[i] = cost[i] + Math.min(backtrack(cost, i+1), backtrack(cost, i+2));
        return dp[i];
    }
}
