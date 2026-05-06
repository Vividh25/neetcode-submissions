class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (freq[c] != 0) {
                freq[s.charAt(l)]--;
                l++;
            }
            freq[c]++;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
