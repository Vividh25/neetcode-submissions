class Solution {
    int ROWS;
    int COLS;
    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;
        Queue<int[]> qAtl = new LinkedList<>();
        Queue<int[]> qPac = new LinkedList<>();
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        //Fill both queues row wise
        for (int i = 0; i < ROWS; i++) {
            qPac.add(new int[]{i, 0});
            qAtl.add(new int[]{i, COLS - 1});
        }

        //Fill both queues column wise
        for (int j = 0; j < COLS; j++) {
            qPac.add(new int[]{0, j});
            qAtl.add(new int[]{ROWS - 1, j});
        }

        //Fill the pacific boolean array using bfs
        bfs(heights, qPac, pac);

        //Fill the atlantic boolean array using bfs
        bfs(heights, qAtl, atl);

        //Traverse both boolean arrays and add the pair of indices which are true in both
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (atl[i][j] && pac[i][j]) ans.add(List.of(i, j));
            }
        }
        return ans;

    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] ocean) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            ocean[row][col] = true;
            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr >= 0 && nc >= 0 && nr <ROWS && nc < COLS && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]) {
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
