class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }
        
        // Rule 1: Count check
        if (xCount != oCount && xCount != oCount + 1) return false;
        
        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');
        
        // Rule 2: If X wins, xCount must be oCount + 1
        if (xWins && xCount != oCount + 1) return false;
        
        // Rule 3: If O wins, xCount must be equal to oCount
        if (oWins && xCount != oCount) return false;
        
        // Rule 4: Both cannot win
        if (xWins && oWins) return false;
        
        return true;
    }
    
    private boolean checkWin(String[] board, char p) {
        for (int i = 0; i < 3; i++) {
            // Rows and Columns
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) return true;
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) return true;
        }
        // Diagonals
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) return true;
        
        return false;
    }
}
