class Solution {
    public int[] getConcatenation(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        int[] ans = new int[2 * n];
        while (i < n && j < 2 * n) {
            ans[j] = nums[i];
            if (i == n - 1) {
                i = 0;
                j++;
                continue;
            }
            i++;
            j++;
        }
        return ans;
    }
}