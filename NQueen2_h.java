class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // Vertical check
        boolean[] diag1 = new boolean[2 * n]; // row - col check
        boolean[] diag2 = new boolean[2 * n]; // row + col check
        
        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // Offset by n to avoid negative indices
            int d2 = row + col;

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place Queen
                cols[col] = diag1[d1] = diag2[d2] = true;

                backtrack(row + 1, n, cols, diag1, diag2);

                // Backtrack (Remove Queen)
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
}
