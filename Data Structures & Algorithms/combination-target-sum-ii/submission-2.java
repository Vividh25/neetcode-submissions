class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, sum, target, curr, ans, candidates);
        return ans;
    }

    public void backtrack(int i, int sum, int target, List<Integer> curr, List<List<Integer>> ans, int[] candidates) {
        //base condition
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (sum + candidates[j] > target) return;
            if (j > i && candidates[j] == candidates[j-1]) continue;
            curr.add(candidates[j]);
            backtrack(j+1, sum + candidates[j], target, curr, ans, candidates);
            curr.remove(curr.size() - 1);
        }
    }
}
