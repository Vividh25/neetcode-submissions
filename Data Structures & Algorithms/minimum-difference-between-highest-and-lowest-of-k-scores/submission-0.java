class Solution {
    public int minimumDifference(int[] nums, int k) {
        //Sort and then apply sliding window
        Arrays.sort(nums);
        int l = 0, ans = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            if  (r - l + 1 == k) {
                int minm = nums[l];
                int maxm = nums[r];
                ans = Math.min(ans, maxm - minm);
                l++;
                System.out.println(ans);
            }
        }
        return ans;
    }
}