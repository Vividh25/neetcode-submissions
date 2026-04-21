class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        
        //count frequencies
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        //Maintain heap of size k
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll(); //remove least frequency if size increases k
        }

        //Build result
        int[] ans = new int[k];
        int i = 0;
        
        while (!minHeap.isEmpty()) ans[i++] = minHeap.poll().getKey();

        return ans;

    }
}
