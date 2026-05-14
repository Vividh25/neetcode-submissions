class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size()];
        return recur(triangle, 0, 0);
    }

    public int recur(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) return 0;


        if (dp[i][j] != null) return dp[i][j];

        int left = triangle.get(i).get(j) + recur(triangle, i + 1, j);
        int right = triangle.get(i).get(j) + recur(triangle, i + 1, j + 1);

        // System.out.println(left + " " + right);

        return dp[i][j] = Math.min(left, right);
    }
}