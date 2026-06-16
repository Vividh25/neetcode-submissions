class Solution {
    int ROWS;
    int COLS;
    int[][] reachable;
    boolean[][] visited;
    public int numEnclaves(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        reachable = new int[ROWS][COLS];
        visited = new boolean[ROWS][COLS];
        int ans = 0;

        //Top and Bottom borders
        for (int j = 0; j < COLS; j++) {
            dfs(0, j, grid);
            dfs(ROWS - 1, j, grid);
        }

        //Left and Right Borders
        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, grid);
            dfs(i, COLS - 1, grid);
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] grid) {
        if (i >= ROWS || j >= COLS || i < 0 || j < 0 || visited[i][j]) return;

        visited[i][j] = true;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs(i + 1, j, grid);
            dfs(i - 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i, j - 1, grid);
        }

    }
}