class Solution {

    public static final int[][] directions =  {{1, 0}, {-1, 0},{0, 1}, {0, -1}};


    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';

        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }

            
        }
    }
}
