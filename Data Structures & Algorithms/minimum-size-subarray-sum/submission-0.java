class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int currSum = 0, ans = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (currSum >= target) {
                ans = Math.min(ans, r - l + 1);
                currSum -= nums[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}