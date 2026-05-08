class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] represents min health needed to survive starting from (i, j)
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    // Base case: Princess room
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else {
                    int resFromDown = (i + 1 < m) ? dp[i + 1][j] : Integer.MAX_VALUE;
                    int resFromRight = (j + 1 < n) ? dp[i][j + 1] : Integer.MAX_VALUE;
                    
                    // Choose the path that requires less health
                    int nextHealth = Math.min(resFromDown, resFromRight);
                    dp[i][j] = Math.max(1, nextHealth - dungeon[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}
