class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxm = 0, ans = 1;
        for (int i : piles) maxm = Math.max(maxm, i);
        int low = 1, high = maxm;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (validSpeed(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    public boolean validSpeed(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
            if (hours > h) return false;
        }
        return true; 
    }
}
