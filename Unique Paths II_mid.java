public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Edge Case: If the starting cell or target cell has an obstacle, no path is possible
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Create a 1D DP array representing the row state
        int[] dp = new int[n];
        
        // Base case: There is exactly 1 way to start at the top-left cell
        dp[0] = 1;
        
        // Traverse the grid row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If there's an obstacle, 0 paths can pass through this cell
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    // Update current cell by adding paths from the left cell
                    // dp[j] currently holds the value from the row above
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n - 1];
    }
}
