class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            pq.add(nums[r]);
            dq.addLast(nums[r]);
            while (r - l + 1 == k) {
                ls.add(pq.peek());
                pq.remove(nums[l]);
                dq.pollFirst();
                l++;
            }
        }
        int[] ans = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) ans[i] = ls.get(i);
        return ans;
    }
}
