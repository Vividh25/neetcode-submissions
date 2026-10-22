class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        while (!pq.isEmpty() || !q.isEmpty()) {
            ans++;

            if (pq.isEmpty()) ans = q.peek()[1];
            else {
                int cnt = pq.poll() - 1;
                if (cnt > 0) q.add(new int[]{cnt, ans + n});
            }

            if (!q.isEmpty() && q.peek()[1] == ans) pq.add(q.poll()[0]);
            
        }
        return ans;
    }
}
