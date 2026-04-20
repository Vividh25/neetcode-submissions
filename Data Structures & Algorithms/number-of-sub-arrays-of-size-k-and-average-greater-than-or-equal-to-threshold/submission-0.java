class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0, l = 0, currSum = 0;

        for (int r = 0; r < arr.length; r++) {
            currSum += arr[r];
            if (r - l + 1 == k) {
                int avg = currSum / k;
                if (avg >= threshold) ans++;
                currSum -= arr[l];
                l++;
            }
        }
        return ans;
    }
}