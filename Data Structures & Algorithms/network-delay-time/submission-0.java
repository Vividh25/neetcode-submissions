class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];
            if (visited.contains(n1)) continue;
            visited.add(n1);
            t = w1;

            if (graph.containsKey(n1)) {
                for (int[] next : graph.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    if (!visited.contains(n2)) minHeap.offer(new int[]{w1 + w2, n2});
                }
            }
        }

        return visited.size() == n ? t : -1;
    }

    
}
