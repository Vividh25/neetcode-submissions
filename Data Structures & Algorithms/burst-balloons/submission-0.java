class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        List<Integer> ls = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ls.add(0, 1);
        int n = nums.length;
        dp = new Integer[n + 2][n + 2];
        ls.add(1);
        return recur(ls, 1, n);
        
    }

    public int recur(List<Integer> ls, int l, int r) {
        if (l > r) return 0;

        if (dp[l][r] != null) return dp[l][r];

        dp[l][r] = 0;
        for(int i = l; i <= r; i++) {
            int coins = ls.get(l - 1) * ls.get(i) * ls.get(r + 1);
            coins += recur(ls, l, i - 1) + recur(ls, i + 1, r);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}
