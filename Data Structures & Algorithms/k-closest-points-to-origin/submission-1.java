class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            pq.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();
            ans[i][0] = point[1];
            ans[i][1] = point[2];
        }

        return ans;

    }
}
