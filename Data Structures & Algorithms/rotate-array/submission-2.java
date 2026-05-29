class Solution {
    public void rotate(int[] nums, int k) {
        int i = 0, j = nums.length - 1;

        while (k-- != 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            while (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
            i = 0;
            j = nums.length - 1;
        }
    }
}