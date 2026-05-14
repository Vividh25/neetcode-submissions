class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        dp = new Integer[s.length() + 1][s.length() + 1];

        return recur(s, rev, 0, 0);
    }

    public int recur(String s, String t, int i, int j) {
        if (i == s.length() || j == t.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int l1 = 0, l2 = 0;
        if (s.charAt(i) == t.charAt(j)) {
            l1 = 1 + recur(s, t, i + 1, j + 1);
        }
        else {
            l2 = Math.max(recur(s, t, i, j + 1), recur(s, t, i + 1, j));
        }

        return dp[i][j] = Math.max(l1, l2);
    }
}