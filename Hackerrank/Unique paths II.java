class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end is an obstacle, no paths are possible
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // Starting point
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip obstacles and the starting cell
                if (obstacleGrid[i][j] == 1 || (i == 0 && j == 0)) {
                    if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                    continue;
                }

                int waysFromTop = (i > 0) ? dp[i - 1][j] : 0;
                int waysFromLeft = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = waysFromTop + waysFromLeft;
            }
        }

        return dp[m - 1][n - 1];
    }
}
