class Solution {
    // Integer[][] dp;
    Map<List<Integer>, Integer> dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        return recur(nums, target, 0);
    }

    public int recur(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0) return 1;
            return 0;
        }

        List<Integer> pair = List.of(i, target);

        if (dp.containsKey(pair)) return dp.get(pair);

        int add = recur(nums, target + nums[i], i + 1);

        int subtract = recur(nums, target - nums[i], i + 1);

        int ways = add + subtract;

        dp.put(List.of(i, target), ways);

        return dp.get(List.of(i, target));
    }
}
