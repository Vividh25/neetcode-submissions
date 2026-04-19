class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(0, ans, curr, nums);
        return ans;
    }

    public void backtracking(int i, List<List<Integer>> ans, List<Integer> curr, int[] nums) {
        
        ans.add(new ArrayList<>(curr));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) continue;
            curr.add(nums[j]);
            backtracking(j+1, ans, curr, nums);
            curr.remove(curr.size() - 1);
        }

    }
}
