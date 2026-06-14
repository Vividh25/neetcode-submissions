class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS;
    int COLS;
    public int shortestBridge(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        boolean[][] visited = new boolean[ROWS][COLS]; 

        outer:
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, q);
                    break outer;
                }
            }
        }

        while (!q.isEmpty()){
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] node = q.poll();
                for (int[] dir : directions) {
                    int nr = node[0] + dir[0], nc = node[1] + dir[1];
                    if (nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || visited[nr][nc]) continue;
                    if (grid[nr][nc] == 1) return ans;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
            ans++;
        }
        
        return -1;
    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j, Queue<int[]> q) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || visited[i][j] || grid[i][j] != 1) return;

        visited[i][j] = true;
        q.add(new int[]{i, j});
        for (int[] dir : directions) dfs(grid, visited, i + dir[0], j + dir[1], q);
    }
}