class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.get(1) - a.get(1));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.forEach((key, value) -> maxHeap.add(Arrays.asList(key, value)));

        List<Integer> ls = new ArrayList<>();
        while (k != 0) {
            List<Integer> freq = new ArrayList<>(maxHeap.poll());
            ls.add(freq.get(0));
            k--;
        }
        int[] ans = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) ans[i] = ls.get(i);

        return ans;
    }
}
