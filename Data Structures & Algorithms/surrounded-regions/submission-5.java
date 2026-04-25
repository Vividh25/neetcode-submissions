class Solution {
    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS, COLS;
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        ROWS = board.length;
        COLS = board[0].length;
        boolean[][] safe = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1) {
                    if (board[i][j] == 'O') dfs(board, i, j, safe);
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!safe[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
    }

    public void dfs(char[][] board, int row, int col, boolean[][] safe) {
        safe[row][col] = true;

        for (int[] dir : directions) {
            int nr = dir[0] + row, nc = dir[1] + col;
            if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && !safe[nr][nc] && board[nr][nc] == 'O') {
                dfs(board, nr, nc, safe);
            }
        }
    }
}
