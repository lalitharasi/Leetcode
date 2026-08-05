public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 1D DP table to store the minimum path sum for the current row
        int[] dp = new int[n];

        // Base case: Initialize the top-left cell cost
        dp[0] = grid[0][0];

        // Initialize the rest of the first row (can only be reached from the left)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Fill the rest of the DP table row by row
        for (int i = 1; i < m; i++) {
            // For the first cell of any row, it can only be reached from above
            dp[0] += grid[i][0];

            for (int j = 1; j < n; j++) {
                // Take the minimum of coming from above (dp[j]) or left (dp[j - 1])
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1];
    }
}
