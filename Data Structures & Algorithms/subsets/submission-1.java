class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtracking(nums, ans, curr, 0);

        return ans;
    }

    public void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> curr, int i) {
        ans.add(new ArrayList<>(curr));

        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtracking(nums, ans, curr, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
