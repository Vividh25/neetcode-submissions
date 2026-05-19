class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }

            int idx = nums[i] - 1;

            if (nums[i] != nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
            else i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }
}