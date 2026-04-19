class Solution {
    int m;
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        m = 0;
        m = Math.max(m, recur(nums, 0));
        return m;
    }

    public int recur (int[] nums, int i) {
        if (i >= nums.length || i < 0) return 0;

        if (dp[i] != 0) return dp[i];

        dp[i] = Math.max((nums[i] + recur(nums, i+2)), recur(nums, i+1));

        return dp[i];
    }
}
