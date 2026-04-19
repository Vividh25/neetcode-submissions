class Solution {
   
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, curr, nums, ans);
        return ans;
    }

    public void backtrack(int i, List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        //base case
        if(i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        //first choice: add the current element to curr list
        curr.add(nums[i]);
        backtrack(i+1, curr, nums, ans);

        //backtrack
        curr.remove(curr.size() - 1);

        //second choice: do not add the current element to curr list
        backtrack(i+1, curr, nums, ans);
    }
}
