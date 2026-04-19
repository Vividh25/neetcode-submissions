class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount + 1];
        int ans = recur (coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int recur(int[] coins, int amount, int i) {

        if (amount == 0) return 0;
        if (i == coins.length) return Integer.MAX_VALUE;
        if (dp[i][amount] != null) return dp[i][amount];
        int take = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            int res = recur(coins, amount - coins[i], i);
            if (res != Integer.MAX_VALUE) take = 1 + res;
        }

        int skip = recur(coins, amount, i + 1);

        dp[i][amount] = Math.min(take, skip);
        return dp[i][amount];
    }
}
