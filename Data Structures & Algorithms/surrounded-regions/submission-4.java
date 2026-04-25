class Solution {
    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] safe = new boolean[ROWS][COLS];

        //Filling the queue with 0s on the border
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1) {
                    if (board[i][j] == 'O') {
                        q.add(new int[] {i, j});
                        safe[i][j] = true;
                    }
                }
            }
        }
        
        //perform bfs
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && board[nr][nc] == 'O' && !safe[nr][nc]) {
                    safe[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O' && !safe[i][j]) board[i][j] = 'X';
            }
        }

    }
}
