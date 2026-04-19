class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;
        int [] map = new int[26];
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            map[c - 'A']++;
            maxFreq = Math.max(maxFreq, map[c - 'A']);

            while ((r - l + 1) - maxFreq > k && l < n) {
                char ch = s.charAt(l);
                map[ch - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
