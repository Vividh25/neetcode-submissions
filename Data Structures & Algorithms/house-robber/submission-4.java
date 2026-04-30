class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        dp = new Integer[nums.length + 1];
        return recur(nums, 0);
    }

    public int recur(int[] nums, int i) {
        if (i >= nums.length) return 0;

        if (dp[i] != null) return dp[i];

        int pick = nums[i] + recur(nums, i + 2);
        int skip = recur(nums, i + 1);

        dp[i] = Math.max(pick, skip);

        return dp[i];
    }
}
