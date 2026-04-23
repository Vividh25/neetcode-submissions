class Solution {

    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = 1 + grid[row][col];
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
