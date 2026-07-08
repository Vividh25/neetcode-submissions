class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int l = 0, r = n - 1;
        int maxLeft = height[l], maxRight = height[r];

        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                ans += maxLeft - height[l];
            }
            else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                ans += maxRight - height[r];
            }
        }
        return ans;
    }
}
