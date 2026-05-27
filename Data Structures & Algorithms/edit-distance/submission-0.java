class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return recur(word1, word2, 0, 0);
    }

    public int recur(String word1, String word2, int i, int j) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if (dp[i][j] != null) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = recur(word1, word2, i + 1, j + 1);
        }
        int insert = recur(word1, word2, i, j + 1);
        int delete = recur(word1, word2, i + 1, j);
        int replace = recur(word1, word2, i + 1, j + 1);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
