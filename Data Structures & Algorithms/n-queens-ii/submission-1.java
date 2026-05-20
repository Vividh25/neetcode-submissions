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

        backtrack(n, 0);
        return ans;
    }

    public void backtrack(int n, int r) {
        if (r == n) {
            ans++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(r, c)) {
                rightDiag.add(r + c);
                leftDiag.add(r - c);
                cols.add(c);

                backtrack(n, r + 1);

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