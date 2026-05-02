class Solution {
    Integer[][] dp;
    // Map<List<Integer>, Integer> dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum + target) % 2 != 0) return 0;

        int targetSum = (sum + target) / 2;
        dp = new Integer[nums.length + 1][targetSum + 1];
        return recur(nums, targetSum, 0);
    }

    public int recur(int[] nums, int targetSum, int i) {
        if (targetSum < 0) return 0;
        if (i == nums.length) {
            if (targetSum == 0) return 1;
            return 0;
        }

        if (dp[i][targetSum] != null) return dp[i][targetSum];

        int add = recur(nums, targetSum - nums[i], i + 1);

        int subtract = recur(nums, targetSum, i + 1);

        dp[i][targetSum] = add + subtract;

        return dp[i][targetSum];
    }
}
