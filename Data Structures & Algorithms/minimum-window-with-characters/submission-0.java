class Solution {
    public String minWindow(String s, String t) {
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;

        for (char c : t.toCharArray()) {
            freq1[c]++;
        }

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (freq1[c] > 0) {
                freq2[c]++;
                if (freq2[c] <= freq1[c]) count++;
            }

            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char ch = s.charAt(l);

                if (freq2[ch] > 0) {
                    freq2[ch]--;
                    if (freq2[ch] < freq1[ch]) count--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }
}
