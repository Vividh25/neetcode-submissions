class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});

            while (pq.peek()[0] <= i - k) pq.poll();
            if (i >= k - 1) ans[idx++] = pq.peek()[1];
        }
        return ans;
    }
}
