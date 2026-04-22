class Solution {

    public static final int[][] directions =  {{1, 0}, {-1, 0},{0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = 0;
        q.add(new int[]{i, j});
        int area = 1;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            
            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    area++;
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }
        return area;
    }
}
