class Solution {

    public static final int[][] directions =  {{1, 0}, {-1, 0},{0, 1}, {0, -1}};
    int ans = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = 0;
                    dfs(grid, i, j);
                    System.out.println(ans);
                    maxArea = Math.max(ans, maxArea);
                }
            }
        }
        return maxArea;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;

        if (grid[i][j] == 1) {
            ans++;
        }

        grid[i][j] = 0;

        for (int[] dir : directions) {
            dfs(grid, dir[0] + i, dir[1] + j);
        }
    }
}
