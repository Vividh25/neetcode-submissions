class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, num + 1);

        if(!map.containsKey(1)) return 1;

        int ans = Integer.MAX_VALUE;

        for (int i : map.keySet()) {
            int num = map.get(i);
            if (!map.containsKey(num) && num > 0) ans = Math.min(ans, num);
        }
        return ans;
    } 
}