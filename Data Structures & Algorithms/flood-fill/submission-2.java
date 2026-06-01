class Solution {
    boolean[][] colored;
    int ROWS;
    int COLS;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ROWS = image.length;
        COLS = image[0].length;
        colored = new boolean[ROWS][COLS];

        dfs(image, sr, sc, colored, image[sr][sc]);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (colored[i][j]) image[i][j] = color;
            }
        }
        return image;
    }

    public void dfs(int[][] image, int i, int j, boolean[][] colored, int originalColor) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || image[i][j] != originalColor || colored[i][j]) return;

        colored[i][j] = true;

        dfs(image, i + 1, j, colored, originalColor);
        dfs(image, i - 1, j, colored, originalColor);
        dfs(image, i, j + 1, colored, originalColor);
        dfs(image, i, j - 1, colored, originalColor);
    }
}