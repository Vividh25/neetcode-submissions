class Solution {
    public int subarraySum(int[] nums, int k) {
        int currSum = 0;
        int ans = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            ans += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}