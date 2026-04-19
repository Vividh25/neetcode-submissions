class Solution {
    // int[] dp1, dp2;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];
        int maxMoney = 0;
        int robFirstHouse = recur(nums, 0, true, dp1);
        int skipFirstHouse = recur(nums, 1, false, dp2);

        return Math.max(robFirstHouse, skipFirstHouse);
    }

    public int recur(int[] nums, int i, boolean robbingFirstHouse, int[]dp) {
        if (robbingFirstHouse == true) {
            if (i >= nums.length - 1 || i < 0) return 0;
        }

        else {
            if (i >= nums.length || i < 0) return 0;
        }

        if (dp[i] != 0) return dp[i];

        int rob = nums[i] + recur(nums, i+2, robbingFirstHouse, dp);
        int skip = recur(nums, i+1, robbingFirstHouse, dp);

        dp[i] = Math.max(rob, skip);

        return dp[i];
    }
}
