class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int total = 0;
        int ans = 0;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];

            while (nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}