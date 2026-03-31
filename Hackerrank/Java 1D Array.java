import java.util.*;

public class Solution {

    /**
     * Determines if a game can be won given a leap size and the game board.
     * @param leap The distance of a jump.
     * @param game The array representing the game board (0 is walkable, 1 is a wall).
     * @return true if the game can be won, false otherwise.
     */
    public static boolean canWin(int leap, int[] game) {
        // Start the recursive depth-first search from index 0
        return isSolvable(leap, game, 0);
    }

    private static boolean isSolvable(int leap, int[] game, int i) {
        // Base Case 1: If the current index is beyond the array, you win!
        if (i >= game.length) {
            return true;
        }
        
        // Base Case 2: If index is negative or we hit a wall/visited cell (1)
        if (i < 0 || game[i] == 1) {
            return false;
        }

        // Mark the current cell as visited by setting it to 1.
        // This prevents the recursion from bouncing back and forth forever.
        game[i] = 1;

        // Recursive Step: Try all three possible moves.
        // If ANY move leads to a win, return true.
        return isSolvable(leap, game, i + leap) || 
               isSolvable(leap, game, i + 1) || 
               isSolvable(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int q = scan.nextInt(); // Number of queries
            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();
                
                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                // Output YES or NO based on the boolean result
                System.out.println((canWin(leap, game)) ? "YES" : "NO");
            }
        }
        scan.close();
    }
}
