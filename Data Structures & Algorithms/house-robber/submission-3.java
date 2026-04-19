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

        int rob = nums[i] + recur(nums, i+2);
        int skip = recur(nums, i+1);

        dp[i] = Math.max(rob, skip);

        return dp[i];
    }
}
