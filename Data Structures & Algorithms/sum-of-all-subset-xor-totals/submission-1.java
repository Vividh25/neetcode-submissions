class Solution {
    public int subsetXORSum(int[] nums) {

        return recur(nums, 0, 0);
    }

    public int recur(int[] nums, int i, int total) {
        if (i == nums.length) return total;

        return recur(nums, i + 1, total ^ nums[i]) + recur(nums, i + 1, total);
    }
}