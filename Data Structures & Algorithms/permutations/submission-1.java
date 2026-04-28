class Solution {
    boolean[] seen;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        seen = new boolean[nums.length];

        backtrack(nums, ans, curr, 0);

        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr, int i) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = 0; j < nums.length; j++) {

            if (!seen[j]) {

                curr.add(nums[j]);
                seen[j] = true;
                backtrack(nums, ans, curr, j + 1);
                curr.remove(curr.size() - 1);
                seen[j] = false;
            }

        }
    }
}
