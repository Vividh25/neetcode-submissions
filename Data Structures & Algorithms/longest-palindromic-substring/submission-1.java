class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        String ans = "";
        for (int i = 0; i < n; i++) {
            //for odd length palindromes
            int l = i, r = i;
            
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    ans = s.substring(l, r + 1);
                    len = r - l + 1;
                }
                r++;
                l--;
            }

            //for even length palindromes
            l = i; 
            r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    ans = s.substring(l, r + 1);
                    len = r - l + 1;
                }
                r++;
                l--;
            }
        }
        return ans;
    }
}
