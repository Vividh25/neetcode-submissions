class Solution {
    Set<Integer> rightDiag;
    Set<Integer> leftDiag;
    Set<Integer> cols;
    int ans;

    public int totalNQueens(int n) {
        rightDiag = new HashSet<>();
        leftDiag = new HashSet<>();
        cols = new HashSet<>();
        ans = 0;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0);
        return ans;
    }

    public void backtrack(char[][] board, int r) {
        if (r == board.length) {
            ans++;
            return;
        }

        for (int c = 0; c < board[0].length; c++) {
            if (isSafe(r, c)) {
                rightDiag.add(r + c);
                leftDiag.add(r - c);
                cols.add(c);

                backtrack(board, r + 1);

                rightDiag.remove(r + c);
                leftDiag.remove(r - c);
                cols.remove(c);
            }
        }
    }

    public boolean isSafe(int r, int c) {
        return (!cols.contains(c)) && (!rightDiag.contains(r + c)) && (!leftDiag.contains(r - c));
    }
}