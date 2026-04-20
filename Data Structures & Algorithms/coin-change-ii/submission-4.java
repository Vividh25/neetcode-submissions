class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return recur(coins, amount, 0);
    }

    public int recur(int[] coins, int amount, int i) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }

        if (dp[i][amount] != null) return dp[i][amount];

        int ways = 0;

        //pick current coin
        if (coins[i] <= amount) {
            ways += recur(coins, amount - coins[i], i);
        }
        //dont pick this coin
        ways += recur(coins, amount, i+1);

        dp[i][amount] = ways;
        return ways;
    }
}
