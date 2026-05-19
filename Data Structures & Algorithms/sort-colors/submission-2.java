class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, mid = 0;

        while (mid <= r) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[l];
                nums[l] = temp;
                mid++;
                l++;
            }
            else if (nums[mid] == 1) mid++;
            else {
                int temp = nums[mid];
                nums[mid] = nums[r];
                nums[r] = temp;
                r--;
            }
        }
    }
}