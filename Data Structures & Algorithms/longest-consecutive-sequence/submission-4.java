class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) return 1;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) set.add(num);
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int length = 1;
                while (set.contains(nums[i] + length)) length++;
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
