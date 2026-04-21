class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else product *= num;
        }

        if (zeroCount > 1) return new int[nums.length];

        int[] ans = new int[nums.length]; 

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) ans[i] = (nums[i] == 0) ? product : 0;
            else ans[i] = product / nums[i];
        }
        return ans;
    }
}  
