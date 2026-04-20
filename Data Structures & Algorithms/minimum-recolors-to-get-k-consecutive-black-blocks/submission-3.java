class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countW = 0, countB = 0, l = 0, n = blocks.length(), ans = Integer.MAX_VALUE;
        // if (n == 1) return 1;

        for (int r = 0; r < n; r++) {
            if (blocks.charAt(r) == 'W') countW++;
            else countB++;

            while (r - l + 1 == k) {
                ans = Math.min(ans, countW);
                // else ans = Math.min(ans, countB);
                if (blocks.charAt(l) == 'W') countW--;
                l++;
                System.out.println(ans);
            }
        }
        return ans;
    }
}