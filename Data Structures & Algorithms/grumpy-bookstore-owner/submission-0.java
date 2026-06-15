class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0, ans = 0;
        int l = 0;

        for (int i = 0; i < customers.length; i++) {
            total += grumpy[i] == 0 ? customers[i] : 0;
        }

        int satisfied;

        for (int r = 0; r < customers.length; r++) {
            if (grumpy[r] == 1) total += customers[r];
            if (r - l + 1 == minutes) {
                ans = Math.max(ans, total);
                if (grumpy[l] == 1) total -= customers[l];
                l++;
            }
        }
        return ans;
    }
}