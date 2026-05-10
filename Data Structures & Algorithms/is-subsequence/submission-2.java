class Solution {
    int[][] dp;
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recur(s, t, 0, 0);
    }

    public boolean recur(String s, String t, int i, int j) {
        if (i == s.length()) return true;
        if (j == t.length()) return false;

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = recur(s, t, i + 1, j + 1) ?  1 : 0;       
        }
        else {
           dp[i][j] = recur(s, t, i, j + 1) ? 1 : 0;
        }
        return dp[i][j] == 1;
    }
}