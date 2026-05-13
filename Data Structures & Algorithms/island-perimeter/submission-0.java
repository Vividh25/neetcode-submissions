class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        int ans = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] node = q.poll();
                        int row = node[0], col = node[1];
                        for (int[] dir : directions) {
                            int nr = row + dir[0], nc = col + dir[1];
                            if (nr >= ROWS || nc >= COLS || nr < 0 || nc < 0 || grid[nr][nc] == 0) {
                                ans++;
                            }
                            else if (!visited[nr][nc]){
                                q.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    return ans;
                    // System.out.println(ans); 
                }
            }
        }
        return ans;
    }
}