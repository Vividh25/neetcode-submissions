class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new Integer[n + 1][m + 1];

        return recur(text1, n, text2, m);
    }

    public int recur(String text1, int n, String text2, int m) {
        if (n == 0 || m == 0) return 0;

        if (dp[n][m] != null) return dp[n][m];

        int l1 = 0, l2 = 0;

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            l1 = 1 + recur(text1, n - 1, text2, m - 1);
        }
        else {
            l2 = Math.max(recur(text1, n, text2, m - 1), recur(text1, n - 1, text2, m));
        }

        return dp[n][m] = Math.max(l1, l2);
    }
}
