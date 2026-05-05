class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new Integer[n + 1][n + 1];

        return recur(nums, 0, -1);
    }

    public int recur(int[] nums, int idx, int prevIdx) {

        if (idx == nums.length) return 0;

        if (dp[idx][prevIdx + 1] != null) return dp[idx][prevIdx + 1];

        int notTake = recur(nums, idx + 1, prevIdx);

        int take = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
            take = 1 + recur(nums, idx + 1, idx);
        }

        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }
}
