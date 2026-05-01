class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;

        dp = new Boolean[nums.length + 1][target + 1];

        return recur(nums, 0, target);
    }

    public boolean recur(int[] nums, int i, int target) {
        if (target == 0) return true;

        if (i >= nums.length || target < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean pick = recur(nums, i + 1, target - nums[i]);
        boolean skip = recur(nums, i + 1, target);

        dp[i][target] = pick || skip;

        return dp[i][target];
    }
}
