class Solution {

    public static final int[][] directions =  {{1, 0}, {-1, 0},{0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int area = 1;

        for (int[] dir : directions) {
            area += dfs(grid, dir[0] + i, dir[1] + j);
        }
        return area;
    }
}
