class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] stores whether s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Base case: empty string matches pattern if pattern contains only '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char patternChar = p.charAt(j - 1);
                
                if (patternChar == '*') {
                    // Case 1: '*' matches empty sequence -> dp[i][j-1]
                    // Case 2: '*' matches 1 or more characters -> dp[i-1][j]
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (patternChar == '?' || s.charAt(i - 1) == patternChar) {
                    // Current characters match, inherit result from preceding diagonals
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
