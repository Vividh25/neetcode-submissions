class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        int sum = 0;
        backtracking(nums, target, ans, curr, sum, 0);

        return ans;
    }

    public void backtracking(int[] nums, int target, List<List<Integer>> ans, List<Integer> curr, int currSum, int i) {
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i >= nums.length) return;

        if (currSum > target) return;

        //Option 1 : Use current element and stay at current index
        curr.add(nums[i]);
        backtracking(nums, target, ans, curr, currSum + nums[i], i);

        //Option 2 : Dont use current element and move on
        curr.remove(curr.size() - 1);
        backtracking(nums, target, ans, curr, currSum, i + 1);
    }
}
