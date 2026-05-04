class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        // Base case: empty string and empty pattern
        dp[0][0] = true;

        // Handle patterns starting with '*' matching empty string
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char currP = p.charAt(j - 1);
                
                if (currP == '?' || currP == s.charAt(i - 1)) {
                    // Current characters match, look at the previous diagonal
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currP == '*') {
                    // '*' matches empty sequence (dp[i][j-1]) 
                    // OR '*' matches at least one char (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
