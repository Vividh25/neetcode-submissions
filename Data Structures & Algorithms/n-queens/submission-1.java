class Solution {
    Set<Integer> cols;
    Set<Integer> leftDiag;
    Set<Integer> rightDiag;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        cols = new HashSet<>();
        leftDiag = new HashSet<>();
        rightDiag = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, ans);

        return ans;
    }
    
    public void backtrack(char[][] board, int r, List<List<String>> ans) {
        if (r == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            ans.add(copy);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (isSafe(r, c)) {
                cols.add(c);
                leftDiag.add(r - c);
                rightDiag.add(r + c);
                board[r][c] = 'Q';

                backtrack(board, r + 1, ans);

                cols.remove(c);
                leftDiag.remove(r - c);
                rightDiag.remove(r + c);
                board[r][c] = '.';
            }
        }
    }

    public boolean isSafe(int r, int c) {
        return (!cols.contains(c)) && (!leftDiag.contains(r - c)) && (!rightDiag.contains(r + c));
    }
}
