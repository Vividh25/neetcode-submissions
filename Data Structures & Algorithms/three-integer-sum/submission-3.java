class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int num = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int currSum = num + nums[j] + nums[k];
                // System.out.println(currSum);
                if (currSum > 0) k--;
                else if (currSum < 0) j++;
                else {
                    // System.out.println(Arrays.asList(num, nums[j], nums[k]));
                    ans.add(Arrays.asList(num, nums[j], nums[k]));
                    j++;
                    k--;
                    
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--; 
                }
            }
        }
        return ans;
    }
}
