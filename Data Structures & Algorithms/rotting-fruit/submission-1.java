class Solution {

    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) fresh++;
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            while (size-- != 0) {
                int[] node = q.poll();
                int row = node[0], col = node[1];
                for (int[] dir : directions) {
                    int nr = dir[0] + row, nc = dir[1] + col;
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            ans++;
        }
        return fresh == 0 ? ans : -1;
    }
}
