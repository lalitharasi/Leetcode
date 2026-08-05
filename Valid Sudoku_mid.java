import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create an array of HashSets for rows, columns, and 3x3 boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize each HashSet
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the entire 9x9 board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Skip empty cells
                if (val == '.') {
                    continue;
                }

                // Calculate the index of the 3x3 sub-box
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check for duplicates in the current row, column, or sub-box
                if (rows[r].contains(val) || cols[c].contains(val) || boxes[boxIndex].contains(val)) {
                    return false;
                }

                // Add the value to the respective tracking sets
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}
