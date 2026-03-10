class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 1D array to store paths for the current row
        int[] dp = new int[n];
        
        // Initialize the first row: there's only 1 way to reach any cell in the first row (all Rights)
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // Iterate through the rest of the rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Number of ways to reach current cell = 
                // ways from above (current dp[j]) + ways from left (updated dp[j-1])
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
