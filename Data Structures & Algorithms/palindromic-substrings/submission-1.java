class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j] != 0) continue;
                String substr = s.substring(i, j+1);
                if(isPalindrome(substr)) {
                    count++;
                    dp[i][j] = 1;
                } 
            }
        }
        return count;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
