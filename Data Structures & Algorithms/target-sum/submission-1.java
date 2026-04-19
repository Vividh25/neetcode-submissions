class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        recur(nums, target, 0);
        return ans;
    }

    public void recur(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0) {
                ans++;
                return;
            }
            return;
        }

        //Add the number to sum
        recur(nums, target - nums[i], i + 1);

        //Subtract the number from the sum
        recur(nums, target + nums[i], i + 1);

    }
}
