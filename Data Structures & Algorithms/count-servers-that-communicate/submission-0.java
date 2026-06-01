class Solution {
    public int countServers(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[] rowCount = new int[ROWS];
        int[] colCount = new int[COLS];
        int ans = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) ans++;
            }
        }
        return ans;
    }
}