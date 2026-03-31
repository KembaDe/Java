class Solution {
    public int numTrees(int n) {
        // dp[i] stores the number of unique BSTs with i nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Single node
        
        // Fill dp table from 2 up to n
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                // Left subtrees * Right subtrees
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        
        return dp[n];
    }
}
