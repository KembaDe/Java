class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        // dp[i][j] means number of distinct subsequences of s[0...j-1] which equals t[0...i-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: If t is empty, there is 1 empty subsequence in any prefix of s
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // Match: (Use the char from s) + (Skip the char from s)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // No match: Must skip the char from s
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
