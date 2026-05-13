class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(n, k, ans, curr, 1);
        return ans;
    }

    public void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> curr, int i) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j <= n; j++) {
            curr.add(j);
            backtrack(n, k, ans, curr, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}