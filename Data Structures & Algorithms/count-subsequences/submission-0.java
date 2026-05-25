class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return recur(s, t, 0, 0);
    }

    public int recur(String s, String t, int i, int j) {
        if (j >= t.length()) return 1;
        if (i >= s.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int ans = 0;

        if (s.charAt(i) == t.charAt(j)) {
            ans +=  recur(s, t, i + 1, j + 1);
        }

        ans += recur(s, t, i + 1, j);

        return dp[i][j] = ans;
    }
}
