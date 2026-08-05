import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 1D DP array representing the current row
        int[] dp = new int[n];
        
        // Base case: There is exactly 1 way to reach any cell in the first row (by moving only right)
        Arrays.fill(dp, 1);
        
        // Iterate through the remaining m - 1 rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The new value is the cell to the left plus the old value from the row above
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}
