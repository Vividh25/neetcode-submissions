class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length + 1];
        return recur(nums, 0);
    }

    public boolean recur(int[] nums, int i) {
        if (i == nums.length - 1) return true;

        if (dp[i] != null) return dp[i];

        for (int j = 1; j <= nums[i]; j++) {
            if (recur(nums, i + j)) return dp[i] = true;
        }
        return dp[i] = false;
    }
}
