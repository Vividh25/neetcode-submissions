class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        Arrays.fill(seen, false);

        backtracking(seen, curr, ans, nums);
        return ans;
    }

    public void backtracking(boolean[] seen, List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
                if(!seen[j]) {
                seen[j] = true;
                curr.add(nums[j]);
                backtracking(seen, curr, ans, nums);
                curr.remove(curr.size() - 1);
                seen[j] = false; 
            }
        }
    }
}
