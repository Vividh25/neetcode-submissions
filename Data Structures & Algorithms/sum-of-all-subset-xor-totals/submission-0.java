class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        sum = 0;
        backtrack(nums, 0, curr);
        return sum;
    }

    public void backtrack(int[] nums, int i, List<Integer> curr) {
        int xor = 0;

        for (int n : curr) {
            xor = xor ^ n;
        }

        sum += xor;

        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);

            backtrack(nums, j + 1, curr);

            curr.remove(curr.size() - 1);
        }
    }
}