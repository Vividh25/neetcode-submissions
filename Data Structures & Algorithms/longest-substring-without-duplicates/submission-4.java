class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int l = 0;
        int maxLen = 0;
        int[] freq = new int[256];
        Arrays.fill(freq, 0);
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(freq[c] != 0) {
                char ch = s.charAt(l);
                freq[ch]--;
                l++;
            }
            freq[c]++;
            
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
