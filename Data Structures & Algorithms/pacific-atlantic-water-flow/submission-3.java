class Solution {
    int ROWS;
    int COLS;
    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length; COLS = heights[0].length;
        boolean atl[][] = new boolean[ROWS][COLS];
        boolean pac[][] = new boolean[ROWS][COLS];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            dfs(heights, i, 0, pac);
            dfs(heights, i, COLS - 1, atl);
        }

        for (int j = 0; j < COLS; j++) {
            dfs(heights, 0, j, pac);
            dfs(heights, ROWS - 1, j, atl);
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (atl[i][j] && pac[i][j]) ans.add(List.of(i, j));
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, int i, int j, boolean[][] ocean) {

        // if (heights[i][j] < prevVal) return;

        ocean[i][j] = true;

        for (int[] dir : directions) {
            int nr = i + dir[0], nc = j + dir[1];
            if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !ocean[nr][nc] && heights[nr][nc] >= heights[i][j]) {
                dfs(heights, nr, nc, ocean);
            }
        }
        
    }
}
