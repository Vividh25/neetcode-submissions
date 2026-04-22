class Solution {
    public boolean isValidSudoku(char[][] board) {

        //Check rows
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (set.contains(ch)) return false;
                    set.add(ch);
                }

            }
        }

        //Check columns
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (set.contains(ch)) return false;
                    set.add(ch);
                }
            }
        }

        //Check 3x3 rows
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                Set<Character> set = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char ch = board[boxRow + i][boxCol + j];
                        if (ch != '.') {
                            if (set.contains(ch)) return false;
                            set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
}
