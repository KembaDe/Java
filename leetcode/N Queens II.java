class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        // Trackers for occupied columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + n

        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;

            // Check if placing a queen here is safe
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place queen (mark trackers)
                cols[col] = diag1[d1] = diag2[d2] = true;

                backtrack(row + 1, n, cols, diag1, diag2);

                // Backtrack (unmark trackers)
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
}
