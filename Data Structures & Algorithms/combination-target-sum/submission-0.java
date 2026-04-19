class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        backtrack(0, sum, curr, nums, target, ans);
        return ans;
    }

    public void backtrack(int i, int sum, List<Integer> curr, int[] nums, int target, List<List<Integer>> ans) {
        
        //base case
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int j = i; j < nums.length; j++) {
            if(sum + nums[j] > target) return;

            curr.add(nums[j]);
            backtrack(j, sum + nums[j], curr, nums, target, ans);
            curr.remove(curr.size() - 1);
        }


    }
}
