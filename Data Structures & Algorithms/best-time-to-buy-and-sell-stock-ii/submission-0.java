class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return recur(prices, 0, 0);
    }

    public int recur(int[] prices, int i, int bought) {
        if (i == prices.length) return 0;

        if (dp[i][bought] != -1) return dp[i][bought];
        int res = recur(prices, i + 1, bought);

        if (bought == 1) res = Math.max(res, prices[i] + recur(prices, i + 1, 0));
        else res = Math.max(res, - prices[i] + recur(prices, i + 1, 1));

        return dp[i][bought] = res;

    }
}